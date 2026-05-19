package com.in2it.cats.procedure_scheduler.controller;

import com.in2it.cats.procedure_scheduler.entity.TenantProcedure;
import com.in2it.cats.procedure_scheduler.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduler")
@RequiredArgsConstructor
public class ProcedureSchedulerController {

    private final SchedulerService service;

    @PostMapping("/register")
    public String register(@RequestBody TenantProcedure request) throws Exception {
        return service.registerAndSchedule(request);
    }
}