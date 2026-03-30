package com.mvet.presidency.audit.repository.AuditLogRepository;

import com.mvet.presidency.audit.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}
