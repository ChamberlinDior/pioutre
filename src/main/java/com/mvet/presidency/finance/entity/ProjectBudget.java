package com.mvet.presidency.finance.entity;

import com.mvet.presidency.common.entity.AuditableEntity;
import com.mvet.presidency.projects.entity.Project;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "project_budgets")
public class ProjectBudget extends AuditableEntity {

    @ManyToOne(optional = false) @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne @JoinColumn(name = "funding_source_id")
    private FundingSource fundingSource;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal allocatedAmount;

    @Column(precision = 18, scale = 2)
    private BigDecimal engagedAmount = BigDecimal.ZERO;

    @Column(precision = 18, scale = 2)
    private BigDecimal disbursedAmount = BigDecimal.ZERO;

    public Project getProject() { return project; }
    public FundingSource getFundingSource() { return fundingSource; }
    public BigDecimal getAllocatedAmount() { return allocatedAmount; }
    public BigDecimal getEngagedAmount() { return engagedAmount; }
    public BigDecimal getDisbursedAmount() { return disbursedAmount; }

    public void setProject(Project project) { this.project = project; }
    public void setFundingSource(FundingSource fundingSource) { this.fundingSource = fundingSource; }
    public void setAllocatedAmount(BigDecimal allocatedAmount) { this.allocatedAmount = allocatedAmount; }
    public void setEngagedAmount(BigDecimal engagedAmount) { this.engagedAmount = engagedAmount; }
    public void setDisbursedAmount(BigDecimal disbursedAmount) { this.disbursedAmount = disbursedAmount; }
}
