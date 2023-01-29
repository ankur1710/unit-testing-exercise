package com.ankur.unittestingexercise.service;

import com.ankur.unittestingexercise.model.ItemEntity;
import com.ankur.unittestingexercise.repository.ItemEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @InjectMocks
    ItemService itemService;

    @Mock
    ItemEntityRepository repository;

    @Test
    public void getAllTest(){
        when(repository.findAll()).thenReturn(
                List.of(
                        new ItemEntity(1,"apple",11),
                        new ItemEntity(2,"banana",111)));

        List<ItemEntity> result = itemService.getAll();
        Assertions.assertEquals(result.get(0).getTotalValue(), 11);
        Assertions.assertEquals(result.get(1).getTotalValue(), 222);
    }


}
