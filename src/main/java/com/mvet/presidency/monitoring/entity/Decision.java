package com.mvet.presidency.monitoring.entity;

import com.mvet.presidency.common.entity.AuditableEntity;
import com.mvet.presidency.projects.entity.Project;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "decisions")
public class Decision extends AuditableEntity {

    @Column(nullable = false, length = 250)
    private String title;

    @Column(length = 4000)
    private String content;

    private LocalDate dueDate;
    private boolean executed;

    @ManyToOne @JoinColumn(name = "project_id")
    private Project project;

    public String getTitle() { return title; }
    public String getContent() { return content; }
    public LocalDate getDueDate() { return dueDate; }
    public boolean isExecuted() { return executed; }
    public Project getProject() { return project; }

    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public void setExecuted(boolean executed) { this.executed = executed; }
    public void setProject(Project project) { this.project = project; }
}
