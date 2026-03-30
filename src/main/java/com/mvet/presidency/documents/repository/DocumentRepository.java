package com.mvet.presidency.documents.repository.DocumentRepository;

import com.mvet.presidency.documents.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
