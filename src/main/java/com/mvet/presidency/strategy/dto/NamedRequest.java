package com.mvet.presidency.strategy.dto;

import jakarta.validation.constraints.NotBlank;

public record NamedRequest(
        @NotBlank String name,
        String code,
        String description) {
}
