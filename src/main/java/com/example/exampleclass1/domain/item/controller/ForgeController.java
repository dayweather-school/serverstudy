package com.example.exampleclass1.domain.item.controller;

import com.example.exampleclass1.domain.item.dto.request.EnhanceRequest;
import com.example.exampleclass1.domain.item.dto.request.UpdateItem;
import com.example.exampleclass1.domain.item.dto.request.CreateItemRequest;
import com.example.exampleclass1.domain.item.dto.response.EnhanceResponse;
import com.example.exampleclass1.domain.item.service.ForgeService;
import com.example.exampleclass1.domain.item.dto.response.ItemResponse;
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

    @DeleteMapping
    public void deleteItem(@RequestParam String name)
    {
        ForgeService.deleteItems(name);
    }

    @PatchMapping("/enhance")
    public EnhanceResponse enhance(@RequestBody EnhanceRequest request)
    {
        return ForgeService.enhance(request);
    }
}
