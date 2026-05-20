package com.example.exampleclass1.domain.item.dto.response;

import com.example.exampleclass1.domain.item.entity.Item;

public record ItemResponse
        (
        String name,
        String type,
        int attackPower,
        int durability,
        int enhanceLevel
        )
{
    public static ItemResponse of(Item item)
    {
        return new ItemResponse(
                item.getName(),
                item.getType(),
                item.getAttackPower(),
                item.getDurability(),
                item.getEnhanceLevel()
        );
    }
}
