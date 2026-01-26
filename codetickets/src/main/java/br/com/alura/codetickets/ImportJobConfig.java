package br.com.alura.codetickets;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ImportJobConfig {
    @Autowired
    private PlatformTransactionManager transactionManager;
    @Bean//gerenciado pelo spring
    public Job job(Step initialStep, JobRepository jobRepository) {
        return new JobBuilder("tickets-generation", jobRepository)
                .start(initialStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    public Step initialStep(ItemReader<Import> reader, ItemWriter<Import> writer,
                            JobRepository jobRepository) {
        return new StepBuilder("initial-step", jobRepository)
                .<Import, Import>chunk(200, this.transactionManager)
                .reader(reader)
                .writer(writer)
                .build();
    }

    @Bean
    public ItemReader<Import> reader() {
        return new FlatFileItemReaderBuilder<Import>()
                .name("csv-reader")
                .resource(new FileSystemResource("files/dados.csv"))
                .comments("--")
                //indicar que está limitado por um caracter em comum
                .delimited()
                .names("cpf", "client", "birthDate", "show", "showDate", "typeEntry", "value")
                .targetType(Import.class)
                .build();
    }
}