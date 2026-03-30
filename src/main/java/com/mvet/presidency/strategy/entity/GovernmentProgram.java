package com.mvet.presidency.strategy.entity;

import com.mvet.presidency.common.entity.NamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "government_programs")
public class GovernmentProgram extends NamedEntity {

    @ManyToOne
    @JoinColumn(name = "pillar_id")
    private StrategicPillar pillar;

    public StrategicPillar getPillar() { return pillar; }
    public void setPillar(StrategicPillar pillar) { this.pillar = pillar; }
}
