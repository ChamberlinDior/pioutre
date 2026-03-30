package com.mvet.presidency.finance.entity;

import com.mvet.presidency.common.entity.AuditableEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "disbursements")
public class Disbursement extends AuditableEntity {

    @ManyToOne(optional = false) @JoinColumn(name = "project_budget_id", nullable = false)
    private ProjectBudget projectBudget;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal amount;

    private LocalDate disbursementDate;

    @Column(length = 250)
    private String referenceNumber;

    public ProjectBudget getProjectBudget() { return projectBudget; }
    public BigDecimal getAmount() { return amount; }
    public LocalDate getDisbursementDate() { return disbursementDate; }
    public String getReferenceNumber() { return referenceNumber; }

    public void setProjectBudget(ProjectBudget projectBudget) { this.projectBudget = projectBudget; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setDisbursementDate(LocalDate disbursementDate) { this.disbursementDate = disbursementDate; }
    public void setReferenceNumber(String referenceNumber) { this.referenceNumber = referenceNumber; }
}
