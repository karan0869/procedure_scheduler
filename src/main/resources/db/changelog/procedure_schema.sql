-- ==========================================
-- TABLE: tenant_procedure_registry
-- ==========================================

CREATE TABLE IF NOT EXISTS tenant_procedure_registry (
                                           id BIGSERIAL PRIMARY KEY,

                                           tenant_id VARCHAR(100) NOT NULL,

                                           procedure_name VARCHAR(255),

                                           cron_expression VARCHAR(100),

                                           is_active BOOLEAN DEFAULT TRUE,

                                           created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                                           updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);