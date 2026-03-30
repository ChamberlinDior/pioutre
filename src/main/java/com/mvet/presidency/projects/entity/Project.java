package com.mvet.presidency.projects.entity;

import com.mvet.presidency.admin.entity.Ministry;
import com.mvet.presidency.admin.entity.User;
import com.mvet.presidency.common.entity.AuditableEntity;
import com.mvet.presidency.projects.enums.PriorityLevel;
import com.mvet.presidency.projects.enums.ProjectStatus;
import com.mvet.presidency.strategy.entity.GovernmentProgram;
import com.mvet.presidency.strategy.entity.PresidentialCommitment;
import com.mvet.presidency.strategy.entity.StrategicPillar;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "projects")
public class Project extends AuditableEntity {

    @Column(nullable = false, unique = true, length = 80)
    private String projectCode;

    @Column(nullable = false, length = 220)
    private String title;

    @Column(length = 4000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private ProjectStatus status = ProjectStatus.IDEE;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private PriorityLevel priority = PriorityLevel.MOYENNE;

    @Column(precision = 18, scale = 2)
    private BigDecimal approvedBudget;

    private LocalDate plannedStartDate;
    private LocalDate plannedEndDate;
    private LocalDate actualStartDate;
    private LocalDate actualEndDate;

    @Column(length = 255)
    private String geographicZone;

    @ManyToOne(optional = false) @JoinColumn(name = "ministry_id", nullable = false)
    private Ministry ministry;

    @ManyToOne @JoinColumn(name = "pillar_id")
    private StrategicPillar pillar;

    @ManyToOne @JoinColumn(name = "program_id")
    private GovernmentProgram program;

    @ManyToOne @JoinColumn(name = "commitment_id")
    private PresidentialCommitment commitment;

    @ManyToOne @JoinColumn(name = "owner_id")
    private User owner;

    public String getProjectCode() { return projectCode; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public ProjectStatus getStatus() { return status; }
    public PriorityLevel getPriority() { return priority; }
    public BigDecimal getApprovedBudget() { return approvedBudget; }
    public LocalDate getPlannedStartDate() { return plannedStartDate; }
    public LocalDate getPlannedEndDate() { return plannedEndDate; }
    public LocalDate getActualStartDate() { return actualStartDate; }
    public LocalDate getActualEndDate() { return actualEndDate; }
    public String getGeographicZone() { return geographicZone; }
    public Ministry getMinistry() { return ministry; }
    public StrategicPillar getPillar() { return pillar; }
    public GovernmentProgram getProgram() { return program; }
    public PresidentialCommitment getCommitment() { return commitment; }
    public User getOwner() { return owner; }

    public void setProjectCode(String projectCode) { this.projectCode = projectCode; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(ProjectStatus status) { this.status = status; }
    public void setPriority(PriorityLevel priority) { this.priority = priority; }
    public void setApprovedBudget(BigDecimal approvedBudget) { this.approvedBudget = approvedBudget; }
    public void setPlannedStartDate(LocalDate plannedStartDate) { this.plannedStartDate = plannedStartDate; }
    public void setPlannedEndDate(LocalDate plannedEndDate) { this.plannedEndDate = plannedEndDate; }
    public void setActualStartDate(LocalDate actualStartDate) { this.actualStartDate = actualStartDate; }
    public void setActualEndDate(LocalDate actualEndDate) { this.actualEndDate = actualEndDate; }
    public void setGeographicZone(String geographicZone) { this.geographicZone = geographicZone; }
    public void setMinistry(Ministry ministry) { this.ministry = ministry; }
    public void setPillar(StrategicPillar pillar) { this.pillar = pillar; }
    public void setProgram(GovernmentProgram program) { this.program = program; }
    public void setCommitment(PresidentialCommitment commitment) { this.commitment = commitment; }
    public void setOwner(User owner) { this.owner = owner; }
}
