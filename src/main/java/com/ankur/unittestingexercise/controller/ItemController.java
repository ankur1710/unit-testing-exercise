package com.ankur.unittestingexercise.controller;

import com.ankur.unittestingexercise.model.Item;
import com.ankur.unittestingexercise.model.ItemEntity;
import com.ankur.unittestingexercise.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/getItem")
    public Item getItem(){
        return new Item(1, "ball");
    }

    @GetMapping("/get-item-service")
    public Item getItemFromBusinessService(){
        return itemService.getItem();
    }


    @GetMapping("/getAll")
    public List<ItemEntity> getAllFromBusinessService(){
        return itemService.getAll();
    }

    @PostMapping("/add-item")
    public ItemEntity addItemEntity(@RequestBody ItemEntity itemEntity){
        return itemService.addItem(itemEntity);
    }
}
