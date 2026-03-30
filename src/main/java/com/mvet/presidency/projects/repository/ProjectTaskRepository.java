package com.mvet.presidency.projects.repository.ProjectTaskRepository;

import com.mvet.presidency.projects.entity.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Long> {
}
