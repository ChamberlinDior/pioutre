package com.mvet.presidency.reporting.service;

import com.mvet.presidency.admin.repository.UserRepository;
import com.mvet.presidency.monitoring.enums.RiskStatus;
import com.mvet.presidency.monitoring.repository.AlertRepository;
import com.mvet.presidency.monitoring.repository.BlockageRepository;
import com.mvet.presidency.monitoring.repository.RiskRepository;
import com.mvet.presidency.projects.enums.ProjectStatus;
import com.mvet.presidency.projects.repository.ProjectRepository;
import com.mvet.presidency.reporting.dto.DashboardSummaryResponse;
import org.springframework.stereotype.Service;

@Service
public class ReportingService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final RiskRepository riskRepository;
    private final BlockageRepository blockageRepository;
    private final AlertRepository alertRepository;

    public ReportingService(ProjectRepository projectRepository,
                            UserRepository userRepository,
                            RiskRepository riskRepository,
                            BlockageRepository blockageRepository,
                            AlertRepository alertRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.riskRepository = riskRepository;
        this.blockageRepository = blockageRepository;
        this.alertRepository = alertRepository;
    }

    public DashboardSummaryResponse getExecutiveSummary() {
        return new DashboardSummaryResponse(
                projectRepository.count(),
                projectRepository.countByStatus(ProjectStatus.CRITIQUE),
                projectRepository.countByStatus(ProjectStatus.VIGILANCE),
                userRepository.count(),
                riskRepository.countByStatus(RiskStatus.OPEN),
                blockageRepository.countByClosedFalse(),
                alertRepository.countByResolvedFalse()
        );
    }
}
