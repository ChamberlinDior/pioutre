package com.mvet.presidency.projects.entity;

import com.mvet.presidency.admin.entity.User;
import com.mvet.presidency.common.entity.NamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "project_tasks")
public class ProjectTask extends NamedEntity {

    private LocalDate dueDate;
    private Integer progressPercentage;

    @ManyToOne(optional = false) @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne @JoinColumn(name = "assignee_id")
    private User assignee;

    public LocalDate getDueDate() { return dueDate; }
    public Integer getProgressPercentage() { return progressPercentage; }
    public Project getProject() { return project; }
    public User getAssignee() { return assignee; }

    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public void setProgressPercentage(Integer progressPercentage) { this.progressPercentage = progressPercentage; }
    public void setProject(Project project) { this.project = project; }
    public void setAssignee(User assignee) { this.assignee = assignee; }
}
