package org.example;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class FlowStep {

    @Bean
    public Flow createFlow(Step step) {
        return new FlowBuilder<Flow>("TheFlow").start(step).build();
    }

    @Bean
    public <I, O> Step createStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager,
            ItemReader itemReader, ItemWriter itemWriter) {

        return new StepBuilder("TheFlow", jobRepository).<I, O>chunk(100, platformTransactionManager) //
                .reader(itemReader).writer(itemWriter).build();
    }

    @Bean
    public ItemReader createItemReader() {
        return () -> null;
    }

    @Bean
    public ItemWriter createItemWriter() {
        return chunk -> {
        };
    }
}