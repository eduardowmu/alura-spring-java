package br.com.alura.bytebank;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class PaymentJobConfiguration {
    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public Job job(Step importStep, JobRepository jobRepository) {
        return new JobBuilder("import", jobRepository)
                .start(importStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    public Step importStep(ItemReader<Payment> reader, ItemWriter<Payment> writer,
                           JobRepository jobRepository) {
        return new StepBuilder("import-payment", jobRepository)
                .<Payment, Payment>chunk(10, this.transactionManager)
                .reader(reader)
                .writer(writer)
                .build();
    }

    @Bean
    public ItemReader<Payment> reader() {
        return new FlatFileItemReaderBuilder<Payment>()
                .name("reader")
                .resource(new FileSystemResource("files/dados_ficticios.csv"))
                .linesToSkip(1)
                .delimited()
                .delimiter("|")
                .names("functionary", "cpf", "agency", "account", "value", "refMonth")
                .targetType(Payment.class)
                .build();
    }

    @Bean
    public ItemWriter<Payment> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Payment>()
                .dataSource(dataSource)
                .sql(
                        "INSERT INTO payment (functionary, cpf, agency, account, value, ref_month) " +
                                "VALUES (:functionary, :cpf, :agency, :account, :value, :refMonth)"
                )
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .build();
    }
}