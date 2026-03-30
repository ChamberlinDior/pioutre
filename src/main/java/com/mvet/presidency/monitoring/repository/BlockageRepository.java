package com.mvet.presidency.monitoring.repository;

import com.mvet.presidency.monitoring.entity.Blockage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockageRepository extends JpaRepository<Blockage, Long> {
    long countByClosedFalse();
}
