package com.mvet.presidency.monitoring.entity;

import com.mvet.presidency.common.entity.NamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "indicators")
public class Indicator extends NamedEntity {

    private String unitName;

    public String getUnitName() { return unitName; }
    public void setUnitName(String unitName) { this.unitName = unitName; }
}
