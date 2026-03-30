package com.mvet.presidency.projects.dto;

import com.mvet.presidency.projects.enums.PriorityLevel;
import com.mvet.presidency.projects.enums.ProjectStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public record ProjectRequest(
        @NotBlank String projectCode,
        @NotBlank String title,
        String description,
        @NotNull ProjectStatus status,
        @NotNull PriorityLevel priority,
        BigDecimal approvedBudget,
        LocalDate plannedStartDate,
        LocalDate plannedEndDate,
        String geographicZone,
        @NotNull Long ministryId,
        Long pillarId,
        Long programId,
        Long commitmentId,
        Long ownerId) {
}
