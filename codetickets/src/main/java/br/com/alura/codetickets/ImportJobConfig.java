package br.com.alura.codetickets;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImportJobConfig {
    @Bean//gerenciado pelo spring
    public Job job(Step initialStep, JobRepository jobRepository) {
        return new JobBuilder("tickets-generation", jobRepository)
                .start(initialStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}