package com.mvet.presidency.strategy.repository;

import com.mvet.presidency.strategy.entity.PresidentialCommitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PresidentialCommitmentRepository extends JpaRepository<PresidentialCommitment, Long> {

    Optional<PresidentialCommitment> findByNameIgnoreCase(String name);

    Optional<PresidentialCommitment> findByCodeIgnoreCase(String code);

    boolean existsByNameIgnoreCase(String name);

    boolean existsByCodeIgnoreCase(String code);

    List<PresidentialCommitment> findAllByDeletedFalse();

    List<PresidentialCommitment> findAllByDeletedFalseOrderByNameAsc();
}