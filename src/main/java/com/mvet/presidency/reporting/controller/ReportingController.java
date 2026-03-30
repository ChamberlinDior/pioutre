package com.mvet.presidency.reporting.controller;

import com.mvet.presidency.common.response.ApiResponse;
import com.mvet.presidency.reporting.dto.DashboardSummaryResponse;
import com.mvet.presidency.reporting.service.ReportingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reporting")
public class ReportingController {

    private final ReportingService reportingService;

    public ReportingController(ReportingService reportingService) {
        this.reportingService = reportingService;
    }

    @GetMapping("/executive-summary")
    public ApiResponse<DashboardSummaryResponse> executiveSummary() {
        return ApiResponse.ok("Synthèse exécutive", reportingService.getExecutiveSummary());
    }
}
