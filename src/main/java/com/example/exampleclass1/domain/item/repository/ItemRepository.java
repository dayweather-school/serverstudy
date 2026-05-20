package com.example.exampleclass1.domain.item.repository;

import com.example.exampleclass1.domain.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item /*Entity*/, Long/*자료명*/>
{
    Optional<Item> findByName(String name);
    // Optional<>은 값이 있을 수 도 있고 없을 수도 있음을 뜻함
}
