package org.example;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ImportJobConfiguration {

    @Bean
    public Job importJob(JobRepository jobRepository, Flow importFlow) {
        return new JobBuilder("Test", jobRepository) //
                .incrementer(new RunIdIncrementer()) //
                .start(importFlow) //
                .end() //
                .build();
    }
}
