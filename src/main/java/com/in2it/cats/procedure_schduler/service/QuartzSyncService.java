package com.in2it.cats.procedure_schduler.service;

import com.in2it.cats.procedure_schduler.entity.TenantProcedure;
import com.in2it.cats.procedure_schduler.repository.TenantProcedureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuartzSyncService {

    private final TenantProcedureRepository repository;

    private final QuartzSchedulerManager schedulerManager;

    public void syncAll() throws Exception {

        List<TenantProcedure> jobs = repository.findByIsActiveTrue();

        for (TenantProcedure p : jobs) {
            schedulerManager.scheduleJob(p);
        }
    }
}
