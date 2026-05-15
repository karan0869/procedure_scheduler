package com.in2it.cats.procedure_schduler.service;

import com.in2it.cats.procedure_schduler.entity.TenantProcedure;
import com.in2it.cats.procedure_schduler.repository.TenantProcedureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchedulerService {
    private final TenantProcedureRepository repository;
    private final QuartzSyncService syncService;
    public String registerAndSchedule(TenantProcedure tp) throws Exception {
        Optional<TenantProcedure> optionalTenantProcedure =
                repository
                        .findByProcedureNameAndTenantId(
                                tp.getProcedureName(),
                                tp.getTenantId()
                        );

        TenantProcedure tenantProcedure = getTenantProcedure(tp, optionalTenantProcedure);
        repository.save(tenantProcedure);
        syncService.syncAll();
        return "Scheduled successfully";
    }

    private static TenantProcedure getTenantProcedure(TenantProcedure tp, Optional<TenantProcedure> optionalTenantProcedure) {
        TenantProcedure tenantProcedure;

        if (optionalTenantProcedure.isPresent()) {

            tenantProcedure = optionalTenantProcedure.get();

        } else {
            tenantProcedure = new TenantProcedure();

            tenantProcedure.setTenantId(
                    tp.getTenantId());

            tenantProcedure.setProcedureName(
                    tp.getProcedureName());

        }
        tenantProcedure.setCronExpression(
                tp.getCronExpression());
        tenantProcedure.setActive(
                tp.isActive());
        return tenantProcedure;
    }
}
