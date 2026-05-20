package com.example.exampleclass1.domain.item.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@Table(name = "itmes")
public class Item
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false) // 아이템 이름은 오직 하나, 값이 없으면 안됨
    private String name; // 아이템 이름

    private String type; // 아이템 유형(칼, 도끼 ...)

    @Setter // 수정될 수 있음
    private int attackPower; // DMG

    @Setter // 수정될 수 있음
    private int enhanceLevel; // 강화 레벨

    @Setter // 수정될 수 있음
    private int durability; // 내구도
}
