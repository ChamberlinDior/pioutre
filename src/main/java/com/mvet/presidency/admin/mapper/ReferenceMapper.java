package com.mvet.presidency.admin.mapper;

import com.mvet.presidency.admin.dto.ReferenceResponse;
import com.mvet.presidency.common.entity.NamedEntity;

public final class ReferenceMapper {

    private ReferenceMapper() {
    }

    public static ReferenceResponse toResponse(NamedEntity entity) {
        return new ReferenceResponse(entity.getId(), entity.getName(), entity.getCode(), entity.getDescription());
    }
}
