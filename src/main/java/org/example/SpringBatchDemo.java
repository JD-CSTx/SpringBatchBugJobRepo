package org.example;

import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.item.database.support.DataFieldMaxValueIncrementerFactory;
import org.springframework.batch.item.database.support.DefaultDataFieldMaxValueIncrementerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Custom {@link DefaultBatchConfiguration} to switch the incrementer factory.
 */
@Configuration
public class SpringBatchDemo extends DefaultBatchConfiguration {

    @Override
    protected DataFieldMaxValueIncrementerFactory getIncrementerFactory() {
        return new DefaultDataFieldMaxValueIncrementerFactory(getDataSource());
    }
}