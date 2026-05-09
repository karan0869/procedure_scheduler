package com.in2it.cats.procedure_schduler.repository;

import com.in2it.cats.procedure_schduler.entity.TenantProcedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantProcedureRepository extends JpaRepository<TenantProcedure, Long> {

    List<TenantProcedure> findByIsActiveTrue();
}
