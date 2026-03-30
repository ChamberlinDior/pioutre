package com.mvet.presidency.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class NamedEntity extends AuditableEntity {

    @Column(nullable = false, length = 180)
    private String name;

    @Column(length = 100)
    private String code;

    @Column(length = 1000)
    private String description;

    public String getName() { return name; }
    public String getCode() { return code; }
    public String getDescription() { return description; }

    public void setName(String name) { this.name = name; }
    public void setCode(String code) { this.code = code; }
    public void setDescription(String description) { this.description = description; }
}
