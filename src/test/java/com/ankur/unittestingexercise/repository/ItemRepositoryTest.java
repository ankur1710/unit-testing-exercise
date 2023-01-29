package com.ankur.unittestingexercise.repository;


import com.ankur.unittestingexercise.model.ItemEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ItemRepositoryTest {

    //data is picked up from src/test/resources

    @Autowired
    private ItemEntityRepository itemEntityRepository;

    @Test
    public void testFindAll(){
        List<ItemEntity> items = itemEntityRepository.findAll();
        Assertions.assertEquals(items.size(), 4);
    }

    @Test
    public void testFindOne(){
        var item = itemEntityRepository.findById(3).orElse(null);
        assert item != null;
        Assertions.assertEquals(item.getName(), "orange");
    }


}
