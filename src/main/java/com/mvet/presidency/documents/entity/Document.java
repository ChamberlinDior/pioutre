package com.mvet.presidency.documents.entity;

import com.mvet.presidency.common.entity.AuditableEntity;
import com.mvet.presidency.documents.enums.DocumentVisibility;
import com.mvet.presidency.projects.entity.Project;
import jakarta.persistence.*;

@Entity
@Table(name = "documents")
public class Document extends AuditableEntity {

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, length = 255)
    private String originalFilename;

    @Column(nullable = false, length = 500)
    private String storagePath;

    @Column(length = 100)
    private String contentType;

    @Enumerated(EnumType.STRING)
    private DocumentVisibility visibility = DocumentVisibility.INTERNAL;

    @ManyToOne @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne @JoinColumn(name = "category_id")
    private DocumentCategory category;

    public String getTitle() { return title; }
    public String getOriginalFilename() { return originalFilename; }
    public String getStoragePath() { return storagePath; }
    public String getContentType() { return contentType; }
    public DocumentVisibility getVisibility() { return visibility; }
    public Project getProject() { return project; }
    public DocumentCategory getCategory() { return category; }

    public void setTitle(String title) { this.title = title; }
    public void setOriginalFilename(String originalFilename) { this.originalFilename = originalFilename; }
    public void setStoragePath(String storagePath) { this.storagePath = storagePath; }
    public void setContentType(String contentType) { this.contentType = contentType; }
    public void setVisibility(DocumentVisibility visibility) { this.visibility = visibility; }
    public void setProject(Project project) { this.project = project; }
    public void setCategory(DocumentCategory category) { this.category = category; }
}
