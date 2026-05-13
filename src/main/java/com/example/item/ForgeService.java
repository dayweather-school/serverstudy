package com.example.item;

import com.example.UpdateItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class ForgeService
{
    private final ItemRepository itemRepository;

    public void createItem(CreateItemRequest request)
    {
        Item foundItem = itemRepository.findByName(request.name()).orElse(null);

        //만약 DB에 이미 있다면
        if(foundItem != null)
        {
            throw new IllegalArgumentException(request.name() + "이름의 아이템이 이미 있습니다");
        }

        // 공격력이 1보다 작을 때
        if(request.attackPower() <= 0)
        {
            throw new IllegalArgumentException("공격력은 1 이상이어야 합니다.");
        }

        if(request.durability() <= 0)
        {
            throw new IllegalArgumentException("내구도는 1 이상이어야 합니다");
        }

        // 내구도가 1보다 작을 때(durability)

        Item item = Item.builder()
                .name(request.name())
                .type(request.type())
                .attackPower(request.attackPower())
                .enhanceLevel(0)
                .durability(request.durability())
                .build();
        itemRepository.save(item);
    }

    // 이름으로 조회
    public ItemResponse findItemById(@RequestParam String name)
    {
        Item item = itemRepository.findByName(name).orElse(null);
        // 만약 DB에 있다면
        if(item == null)
        {
            throw new IllegalArgumentException(name + "는 없는 아이템입니다.");
        }
        return ItemResponse.of(item);
    }

    // 강화 로직 넣기 전 일반 수정 메서드
    public ItemResponse updateItem(UpdateItem request)
    {
        Item item = itemRepository.findByName(request.name()).orElse(null);

        if(item == null)
        {
            throw new IllegalArgumentException(request.name() + "는 없는 아이템입니다.");
        }

        //공격력이 1보다 낮을 때
        if(request.attackPower() <= 0)
        {
            throw new IllegalArgumentException("공격력은 1 이상이어야 합니다.");
        }

        item.setAttackPower(request.attackPower());
        item.setDurability(request.durability());

        itemRepository.save(item);

        return ItemResponse.of(item);
    }

    public ItemResponse deleteItems(@RequestParam String name)
    {
        Item item = itemRepository.findByName(name).orElse(null);

        if(item == null)
        {
            throw new IllegalArgumentException(name + "는 없는 아이템입니다");
        }

        itemRepository.delete(item);

        return ItemResponse.of(item);
    }
}
