package com.in2it.cats.procedure_schduler.service;

import com.in2it.cats.procedure_schduler.entity.TenantProcedure;
import com.in2it.cats.procedure_schduler.quartz.ProcedureJob;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuartzSchedulerManager {

    private final Scheduler scheduler;

    public void scheduleJob(TenantProcedure p) throws Exception {

        JobKey jobKey = JobKey.jobKey(p.getTenantId() + "_" + p.getProcedureName());

        JobDetail jobDetail = JobBuilder.newJob(ProcedureJob.class)
                .withIdentity(jobKey)
                .usingJobData("tenantId", p.getTenantId())
                .usingJobData("procedureName", p.getProcedureName())
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(jobKey.getName() + "_trigger")
                .withSchedule(CronScheduleBuilder.cronSchedule(p.getCronExpression()))
                .build();

        if (scheduler.checkExists(jobKey)) {
            scheduler.deleteJob(jobKey);
        }

        scheduler.scheduleJob(jobDetail, trigger);
    }
}
