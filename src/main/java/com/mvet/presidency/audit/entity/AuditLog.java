package com.mvet.presidency.audit.entity;

import com.mvet.presidency.common.entity.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "audit_logs")
public class AuditLog extends AuditableEntity {

    @Column(nullable = false, length = 120)
    private String action;

    @Column(nullable = false, length = 120)
    private String entityName;

    private Long entityId;

    @Column(length = 150)
    private String actor;

    @Column(length = 4000)
    private String details;

    public String getAction() { return action; }
    public String getEntityName() { return entityName; }
    public Long getEntityId() { return entityId; }
    public String getActor() { return actor; }
    public String getDetails() { return details; }

    public void setAction(String action) { this.action = action; }
    public void setEntityName(String entityName) { this.entityName = entityName; }
    public void setEntityId(Long entityId) { this.entityId = entityId; }
    public void setActor(String actor) { this.actor = actor; }
    public void setDetails(String details) { this.details = details; }
}
