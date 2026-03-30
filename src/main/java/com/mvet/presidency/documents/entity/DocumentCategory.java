package com.mvet.presidency.documents.entity;

import com.mvet.presidency.common.entity.NamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "document_categories")
public class DocumentCategory extends NamedEntity {
}
