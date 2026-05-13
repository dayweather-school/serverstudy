package com.example.item;

public record CreateItemRequest(
        String name,
        String type,
        int attackPower,
        int durability
)
{

}
