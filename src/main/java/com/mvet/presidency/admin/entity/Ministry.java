package com.mvet.presidency.admin.entity;

import com.mvet.presidency.common.entity.NamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ministries")
public class Ministry extends NamedEntity {

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    public Institution getInstitution() { return institution; }
    public void setInstitution(Institution institution) { this.institution = institution; }
}
