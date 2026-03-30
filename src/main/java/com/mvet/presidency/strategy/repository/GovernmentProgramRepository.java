package com.mvet.presidency.strategy.repository;

import com.mvet.presidency.strategy.entity.GovernmentProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GovernmentProgramRepository extends JpaRepository<GovernmentProgram, Long> {

    Optional<GovernmentProgram> findByNameIgnoreCase(String name);

    Optional<GovernmentProgram> findByCodeIgnoreCase(String code);

    boolean existsByNameIgnoreCase(String name);

    boolean existsByCodeIgnoreCase(String code);

    List<GovernmentProgram> findAllByDeletedFalse();

    List<GovernmentProgram> findAllByDeletedFalseOrderByNameAsc();
}