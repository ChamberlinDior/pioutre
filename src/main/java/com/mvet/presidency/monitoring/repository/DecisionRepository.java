package com.mvet.presidency.monitoring.repository.DecisionRepository;

import com.mvet.presidency.monitoring.entity.Decision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DecisionRepository extends JpaRepository<Decision, Long> {
}
