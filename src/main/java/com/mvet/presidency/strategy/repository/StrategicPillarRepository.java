package com.mvet.presidency.strategy.repository;

import com.mvet.presidency.strategy.entity.StrategicPillar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StrategicPillarRepository extends JpaRepository<StrategicPillar, Long> {

    Optional<StrategicPillar> findByNameIgnoreCase(String name);

    Optional<StrategicPillar> findByCodeIgnoreCase(String code);

    boolean existsByNameIgnoreCase(String name);

    boolean existsByCodeIgnoreCase(String code);

    List<StrategicPillar> findAllByDeletedFalse();

    List<StrategicPillar> findAllByDeletedFalseOrderByNameAsc();
}