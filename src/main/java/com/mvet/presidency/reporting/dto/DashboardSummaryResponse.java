package com.mvet.presidency.reporting.dto;

public record DashboardSummaryResponse(
        long totalProjects,
        long criticalProjects,
        long vigilanceProjects,
        long totalUsers,
        long openRisks,
        long openBlockages,
        long unresolvedAlerts) {
}
