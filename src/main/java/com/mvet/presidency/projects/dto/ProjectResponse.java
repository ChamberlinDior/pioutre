package com.mvet.presidency.projects.dto;

import com.mvet.presidency.projects.enums.PriorityLevel;
import com.mvet.presidency.projects.enums.ProjectStatus;
import java.math.BigDecimal;
import java.time.LocalDate;

public record ProjectResponse(
        Long id,
        String projectCode,
        String title,
        String description,
        ProjectStatus status,
        PriorityLevel priority,
        BigDecimal approvedBudget,
        LocalDate plannedStartDate,
        LocalDate plannedEndDate,
        String geographicZone,
        String ministry,
        String pillar,
        String program,
        String commitment,
        String owner) {
}
