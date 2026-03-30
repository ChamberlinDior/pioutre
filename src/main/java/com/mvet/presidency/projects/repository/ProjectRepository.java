package com.mvet.presidency.projects.repository;

import com.mvet.presidency.projects.entity.Project;
import com.mvet.presidency.projects.enums.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    long countByStatus(ProjectStatus status);
}
