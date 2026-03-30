package com.mvet.presidency.documents.repository.DocumentVersionRepository;

import com.mvet.presidency.documents.entity.DocumentVersion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentVersionRepository extends JpaRepository<DocumentVersion, Long> {
}
