package com.in2it.cats.procedure_scheduler.quartz;


import com.in2it.cats.procedure_scheduler.service.ProcedureExecutionService;
import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProcedureJob implements Job {

    private final ProcedureExecutionService executionService;

    @Override
    public void execute(JobExecutionContext context) {

        JobDataMap map = context.getMergedJobDataMap();

        String tenantId = map.getString("tenantId");
        String procedure = map.getString("procedureName");

        executionService.executeProcedure(tenantId, procedure);
    }
}