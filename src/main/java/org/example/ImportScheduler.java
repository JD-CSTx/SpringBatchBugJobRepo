package org.example;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * So Spring doesn't immediately exit, so it has something to do.
 */
@Component
@EnableScheduling
public class ImportScheduler {

    @Scheduled(cron = "10 0 * * * ?")
    public void scheduleImports() {
        // Nothing
    }
}