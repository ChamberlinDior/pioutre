package com.mvet.presidency.monitoring.entity;

import com.mvet.presidency.common.entity.NamedEntity;
import com.mvet.presidency.monitoring.enums.AlertSeverity;
import com.mvet.presidency.monitoring.enums.RiskStatus;
import com.mvet.presidency.projects.entity.Project;
import jakarta.persistence.*;

@Entity
@Table(name = "risks")
public class Risk extends NamedEntity {

    @Enumerated(EnumType.STRING)
    private AlertSeverity severity = AlertSeverity.MEDIUM;

    @Enumerated(EnumType.STRING)
    private RiskStatus status = RiskStatus.OPEN;

    @ManyToOne(optional = false) @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public AlertSeverity getSeverity() { return severity; }
    public RiskStatus getStatus() { return status; }
    public Project getProject() { return project; }

    public void setSeverity(AlertSeverity severity) { this.severity = severity; }
    public void setStatus(RiskStatus status) { this.status = status; }
    public void setProject(Project project) { this.project = project; }
}
