package com.mvet.presidency.monitoring.entity;

import com.mvet.presidency.common.entity.AuditableEntity;
import com.mvet.presidency.projects.entity.Project;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "arbitration_requests")
public class ArbitrationRequest extends AuditableEntity {

    @Column(nullable = false, length = 250)
    private String subject;

    @Column(length = 4000)
    private String summary;

    @Column(length = 120)
    private String requestedLevel;

    private LocalDate dueDate;

    @ManyToOne(optional = false) @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public String getSubject() { return subject; }
    public String getSummary() { return summary; }
    public String getRequestedLevel() { return requestedLevel; }
    public LocalDate getDueDate() { return dueDate; }
    public Project getProject() { return project; }

    public void setSubject(String subject) { this.subject = subject; }
    public void setSummary(String summary) { this.summary = summary; }
    public void setRequestedLevel(String requestedLevel) { this.requestedLevel = requestedLevel; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public void setProject(Project project) { this.project = project; }
}
