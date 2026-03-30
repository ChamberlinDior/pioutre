package com.mvet.presidency.monitoring.entity;

import com.mvet.presidency.common.entity.NamedEntity;
import com.mvet.presidency.monitoring.enums.AlertSeverity;
import com.mvet.presidency.projects.entity.Project;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "blockages")
public class Blockage extends NamedEntity {

    @Enumerated(EnumType.STRING)
    private AlertSeverity severity = AlertSeverity.MEDIUM;

    private LocalDate targetResolutionDate;
    private boolean closed;

    @ManyToOne(optional = false) @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public AlertSeverity getSeverity() { return severity; }
    public LocalDate getTargetResolutionDate() { return targetResolutionDate; }
    public boolean isClosed() { return closed; }
    public Project getProject() { return project; }

    public void setSeverity(AlertSeverity severity) { this.severity = severity; }
    public void setTargetResolutionDate(LocalDate targetResolutionDate) { this.targetResolutionDate = targetResolutionDate; }
    public void setClosed(boolean closed) { this.closed = closed; }
    public void setProject(Project project) { this.project = project; }
}
