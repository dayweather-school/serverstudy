package com.example.item;

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
