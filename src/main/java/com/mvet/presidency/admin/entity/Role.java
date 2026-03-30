package com.mvet.presidency.admin.entity;

import com.mvet.presidency.admin.enums.RoleName;
import com.mvet.presidency.common.entity.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends AuditableEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true, length = 50)
    private RoleName name;

    @Column(length = 255)
    private String description;

    public RoleName getName() { return name; }
    public String getDescription() { return description; }

    public void setName(RoleName name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
}
