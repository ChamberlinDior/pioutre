package com.mvet.presidency.monitoring.entity;

import com.mvet.presidency.common.entity.AuditableEntity;
import com.mvet.presidency.projects.entity.Project;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "project_indicator_values")
public class ProjectIndicatorValue extends AuditableEntity {

    @ManyToOne(optional = false) @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne(optional = false) @JoinColumn(name = "indicator_id", nullable = false)
    private Indicator indicator;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal value;

    private LocalDate measuredOn;

    public Project getProject() { return project; }
    public Indicator getIndicator() { return indicator; }
    public BigDecimal getValue() { return value; }
    public LocalDate getMeasuredOn() { return measuredOn; }

    public void setProject(Project project) { this.project = project; }
    public void setIndicator(Indicator indicator) { this.indicator = indicator; }
    public void setValue(BigDecimal value) { this.value = value; }
    public void setMeasuredOn(LocalDate measuredOn) { this.measuredOn = measuredOn; }
}
