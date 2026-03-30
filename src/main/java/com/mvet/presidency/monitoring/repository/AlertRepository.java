package com.mvet.presidency.monitoring.repository;

import com.mvet.presidency.monitoring.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert, Long> {
    long countByResolvedFalse();
}
