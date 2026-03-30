package com.mvet.presidency.projects.mapper;

import com.mvet.presidency.projects.dto.ProjectResponse;
import com.mvet.presidency.projects.entity.Project;

public final class ProjectMapper {

    private ProjectMapper() {
    }

    public static ProjectResponse toResponse(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getProjectCode(),
                project.getTitle(),
                project.getDescription(),
                project.getStatus(),
                project.getPriority(),
                project.getApprovedBudget(),
                project.getPlannedStartDate(),
                project.getPlannedEndDate(),
                project.getGeographicZone(),
                project.getMinistry() != null ? project.getMinistry().getName() : null,
                project.getPillar() != null ? project.getPillar().getName() : null,
                project.getProgram() != null ? project.getProgram().getName() : null,
                project.getCommitment() != null ? project.getCommitment().getName() : null,
                project.getOwner() != null ? project.getOwner().getFirstName() + " " + project.getOwner().getLastName() : null
        );
    }
}
