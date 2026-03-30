package com.mvet.presidency.projects.entity;

import com.mvet.presidency.common.entity.NamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "project_phases")
public class ProjectPhase extends NamedEntity {

    private LocalDate startDate;
    private LocalDate endDate;
    private Integer progressPercentage;

    @ManyToOne(optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public Integer getProgressPercentage() { return progressPercentage; }
    public Project getProject() { return project; }

    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setProgressPercentage(Integer progressPercentage) { this.progressPercentage = progressPercentage; }
    public void setProject(Project project) { this.project = project; }
}
