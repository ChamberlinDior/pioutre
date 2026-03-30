package com.mvet.presidency.monitoring.repository;

import com.mvet.presidency.monitoring.entity.Risk;
import com.mvet.presidency.monitoring.enums.RiskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskRepository extends JpaRepository<Risk, Long> {
    long countByStatus(RiskStatus status);
}
