package com.mvet.presidency.meetings.entity;

import com.mvet.presidency.common.entity.AuditableEntity;
import com.mvet.presidency.projects.entity.Project;
import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "meetings")
public class Meeting extends AuditableEntity {

    @Column(nullable = false, length = 250)
    private String title;

    private OffsetDateTime scheduledAt;

    @Column(length = 255)
    private String location;

    @ManyToOne @JoinColumn(name = "project_id")
    private Project project;

    public String getTitle() { return title; }
    public OffsetDateTime getScheduledAt() { return scheduledAt; }
    public String getLocation() { return location; }
    public Project getProject() { return project; }

    public void setTitle(String title) { this.title = title; }
    public void setScheduledAt(OffsetDateTime scheduledAt) { this.scheduledAt = scheduledAt; }
    public void setLocation(String location) { this.location = location; }
    public void setProject(Project project) { this.project = project; }
}
