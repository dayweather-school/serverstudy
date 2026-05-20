package com.example.exampleclass1.domain.item.dto.request;

public record UpdateItem
        (
            String name,
            int attackPower,
            int durability
        )
{

}
