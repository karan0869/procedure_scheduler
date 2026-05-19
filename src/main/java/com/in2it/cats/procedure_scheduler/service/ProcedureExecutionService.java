package com.in2it.cats.procedure_scheduler.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcedureExecutionService {

    private final JdbcTemplate jdbcTemplate;

    public void executeProcedure(String tenantId, String procedure) {

        String sql = "CALL public." + procedure + "()";

        System.out.println("Executing for tenant: " + tenantId);

        jdbcTemplate.execute(sql);
    }
}
