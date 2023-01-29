package com.ankur.unittestingexercise.service;

import com.ankur.unittestingexercise.model.Item;
import com.ankur.unittestingexercise.model.ItemEntity;
import com.ankur.unittestingexercise.repository.ItemEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemEntityRepository repository;

    public Item getItem() {
        return new Item(1, "apple");
    }

    public List<ItemEntity> getAll() {
        List<ItemEntity> result = repository.findAll();
        result.forEach(
                itemEntity -> itemEntity.setTotalValue(itemEntity.getQuantity() * itemEntity.getId()));
        return result;
    }

    public ItemEntity addItem(ItemEntity itemEntity) {
        return repository.save(itemEntity);
    }
}
