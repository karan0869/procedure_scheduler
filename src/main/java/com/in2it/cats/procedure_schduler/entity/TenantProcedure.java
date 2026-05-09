package com.in2it.cats.procedure_schduler.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "tenant_procedure_registry")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TenantProcedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="tenant_id",nullable = false)
    private String tenantId;
    @Column(name="procedure_name")
    private String procedureName;
    @Column(name="cron_expression")
    private String cronExpression;
    @Column(name="is_active")
    private boolean isActive = true;
    @Column(name="created_date")
    @CreationTimestamp
    private Instant createdDate;
    @Column(name="updated_date")
    @UpdateTimestamp
    private Instant updatedDate;
}
