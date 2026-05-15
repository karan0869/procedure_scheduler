package com.in2it.cats.procedure_schduler.repository;

import com.in2it.cats.procedure_schduler.entity.TenantProcedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TenantProcedureRepository extends JpaRepository<TenantProcedure, Long> {

    List<TenantProcedure> findByIsActiveTrue();
    @Query("""
            SELECT tp
            FROM TenantProcedure tp
            WHERE tp.procedureName = :procedureName
            AND tp.tenantId = :tenantId
            """)
    Optional<TenantProcedure> findByProcedureNameAndTenantId(
            @Param("procedureName") String procedureName,
            @Param("tenantId") String tenantId
    );
}
