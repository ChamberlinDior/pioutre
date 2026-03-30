package com.mvet.presidency.projects.entity;

import com.mvet.presidency.common.entity.NamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "milestones")
public class Milestone extends NamedEntity {

    private LocalDate targetDate;
    private LocalDate achievedDate;
    private boolean completed;

    @ManyToOne(optional = false) @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public LocalDate getTargetDate() { return targetDate; }
    public LocalDate getAchievedDate() { return achievedDate; }
    public boolean isCompleted() { return completed; }
    public Project getProject() { return project; }

    public void setTargetDate(LocalDate targetDate) { this.targetDate = targetDate; }
    public void setAchievedDate(LocalDate achievedDate) { this.achievedDate = achievedDate; }
    public void setCompleted(boolean completed) { this.completed = completed; }
    public void setProject(Project project) { this.project = project; }
}
