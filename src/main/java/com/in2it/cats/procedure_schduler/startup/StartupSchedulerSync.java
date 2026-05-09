package com.in2it.cats.procedure_schduler.startup;

import com.in2it.cats.procedure_schduler.service.QuartzSyncService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupSchedulerSync {

    private final QuartzSyncService syncService;

    @PostConstruct
    public void init() throws Exception {
        syncService.syncAll();
    }
}
