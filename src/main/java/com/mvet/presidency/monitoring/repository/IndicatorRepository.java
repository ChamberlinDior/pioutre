package com.mvet.presidency.monitoring.repository.IndicatorRepository;

import com.mvet.presidency.monitoring.entity.Indicator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndicatorRepository extends JpaRepository<Indicator, Long> {
}
