package br.com.mybusy.mybatch.job;

import br.com.mybusy.db.db_core.model.Client;
import br.com.mybusy.db.db_core.repository.ClientRepository;
import br.com.mybusy.mybatch.dto.ClientDTO;
import br.com.mybusy.mybatch.mapper.ClientMapper;
import br.com.mybusy.mybatch.model.MyClient;
import br.com.mybusy.mybatch.repository.MyClientRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class ClientJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final ClientRepository clientRepository;
    private final MyClientRepository myClientRepository;
    private final ClientMapper clientMapper;

    @Qualifier("pgTransactionManager")
    private final PlatformTransactionManager pgTransactionManager;

    @Qualifier("mysqlEntityManager")
    private final EntityManagerFactory mysqlEmf;

    @Autowired
    public ClientJobConfig(JobBuilderFactory jobBuilderFactory,
                           StepBuilderFactory stepBuilderFactory,
                           ClientRepository clientRepository,
                           MyClientRepository myClientRepository,
                           ClientMapper clientMapper,
                           PlatformTransactionManager pgTransactionManager,
                           EntityManagerFactory mysqlEmf) {

        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.clientRepository = clientRepository;
        this.myClientRepository = myClientRepository;
        this.clientMapper = clientMapper;
        this.pgTransactionManager = pgTransactionManager;
        this.mysqlEmf = mysqlEmf;
    }

    // ======================
    // READER
    // ======================
    @Bean
    public JpaPagingItemReader<Client> clientReader() {

        JpaPagingItemReader<Client> reader = new JpaPagingItemReader<>();

        reader.setEntityManagerFactory(mysqlEmf);

        reader.setQueryString("SELECT c FROM Client c");

        reader.setPageSize(100);

        return reader;
    }

    // ======================
    // PROCESSOR
    // ======================
    @Bean
    public ItemProcessor<Client, MyClient> clientProcessor() {

        return client -> {

            ClientDTO dto = clientMapper.toDTO(client);

            return clientMapper.toEntity(dto);
        };
    }

    // ======================
    // WRITER
    // ======================
    @Bean
    public ItemWriter<MyClient> clientWriter() {

        return items -> myClientRepository.saveAll(items);
    }

    // ======================
    // STEP
    // ======================
    @Bean
    public Step clientStep() {

        return stepBuilderFactory.get("clientStep")
                .<Client, MyClient>chunk(100)
                .reader(clientReader())
                .processor(clientProcessor())
                .writer(clientWriter())
                .transactionManager(pgTransactionManager)
                .build();
    }

    // ======================
    // JOB
    // ======================
    @Bean
    public Job clientJob() {

        return jobBuilderFactory.get("clientJob")
                .start(clientStep())
                .build();
    }
}