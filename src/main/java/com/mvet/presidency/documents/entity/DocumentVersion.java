package com.mvet.presidency.documents.entity;

import com.mvet.presidency.common.entity.AuditableEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "document_versions")
public class DocumentVersion extends AuditableEntity {

    @ManyToOne(optional = false) @JoinColumn(name = "document_id", nullable = false)
    private Document document;

    @Column(nullable = false)
    private Integer versionNumber;

    @Column(nullable = false, length = 500)
    private String storagePath;

    public Document getDocument() { return document; }
    public Integer getVersionNumber() { return versionNumber; }
    public String getStoragePath() { return storagePath; }

    public void setDocument(Document document) { this.document = document; }
    public void setVersionNumber(Integer versionNumber) { this.versionNumber = versionNumber; }
    public void setStoragePath(String storagePath) { this.storagePath = storagePath; }
}
