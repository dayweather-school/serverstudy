package com.example.item;

import com.example.UpdateItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forge")
@RequiredArgsConstructor
public class ForgeController
{
    private final ForgeService ForgeService;

    @PostMapping
    public void createItem(@RequestBody CreateItemRequest request)
    {
        ForgeService.createItem(request);
    }

    @GetMapping
    public ItemResponse findItemById(@RequestParam String name)
    {
        return ForgeService.findItemById(name);
    }

    @PatchMapping("/update")
    public ItemResponse updateitem(@RequestBody UpdateItem request)
    {
        return ForgeService.updateItem(request);
    }

}
