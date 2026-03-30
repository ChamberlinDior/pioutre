package com.mvet.presidency.admin.entity;

import com.mvet.presidency.common.entity.NamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class Department extends NamedEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "ministry_id", nullable = false)
    private Ministry ministry;

    public Ministry getMinistry() { return ministry; }
    public void setMinistry(Ministry ministry) { this.ministry = ministry; }
}
