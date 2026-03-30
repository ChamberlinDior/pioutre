package com.mvet.presidency.monitoring.entity;

import com.mvet.presidency.common.entity.AuditableEntity;
import com.mvet.presidency.monitoring.enums.AlertSeverity;
import com.mvet.presidency.projects.entity.Project;
import jakarta.persistence.*;

@Entity
@Table(name = "alerts")
public class Alert extends AuditableEntity {

    @Column(nullable = false, length = 250)
    private String title;

    @Column(length = 4000)
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private AlertSeverity severity = AlertSeverity.INFO;

    private boolean resolved;

    @ManyToOne @JoinColumn(name = "project_id")
    private Project project;

    public String getTitle() { return title; }
    public String getMessage() { return message; }
    public AlertSeverity getSeverity() { return severity; }
    public boolean isResolved() { return resolved; }
    public Project getProject() { return project; }

    public void setTitle(String title) { this.title = title; }
    public void setMessage(String message) { this.message = message; }
    public void setSeverity(AlertSeverity severity) { this.severity = severity; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
    public void setProject(Project project) { this.project = project; }
}
