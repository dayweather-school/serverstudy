package com.example.exampleclass1.domain.item.dto.response;

public record EnhanceResponse(
        String name,
        boolean success,
        int attackPower,
        int durability,
        int enhanceLevel,
        String message
) {
}
