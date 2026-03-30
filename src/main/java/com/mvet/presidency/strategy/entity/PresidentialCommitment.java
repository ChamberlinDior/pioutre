package com.mvet.presidency.strategy.entity;

import com.mvet.presidency.common.entity.NamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "presidential_commitments")
public class PresidentialCommitment extends NamedEntity {

    @ManyToOne
    @JoinColumn(name = "program_id")
    private GovernmentProgram program;

    public GovernmentProgram getProgram() { return program; }
    public void setProgram(GovernmentProgram program) { this.program = program; }
}
