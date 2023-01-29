package com.ankur.unittestingexercise.controller;


import com.ankur.unittestingexercise.model.Item;
import com.ankur.unittestingexercise.model.ItemEntity;
import com.ankur.unittestingexercise.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ItemService itemService;

    @Test
    public void getItemsTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/getItem")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1,\"name\":\"ball\"}"))
                .andReturn();
//        JSONAssert.assertEquals(expected, actual, strict); // we can use it as well
    }

    @Test
    public void getItemsFromServiceTest() throws Exception {
        when(itemService.getItem()).thenReturn(new Item(2,"apple"));
        RequestBuilder request = MockMvcRequestBuilders
                .get("/get-item-service")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id: 2,name:apple}"))
                .andReturn();

    }

    @Test
    public void getAllItemsFromServiceTest() throws Exception {
        when(itemService.getAll()).thenReturn(List.of(
                new ItemEntity(1,"apple",11),
                new ItemEntity(2,"banana",111)));
        RequestBuilder request = MockMvcRequestBuilders
                .get("/getAll")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:1,name:apple},{}]"))
                .andExpect(content().json("[{id:1,name:apple},{id:2,name:banana}]"))
                .andReturn();

    }

    @Test
    public void addItemTest() throws Exception {
        ItemEntity itemEntity = new ItemEntity(5,"cherry",111);
        when(itemService.addItem(itemEntity)).thenReturn(itemEntity);

        RequestBuilder request = MockMvcRequestBuilders
                .post("/add-item")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\"id\":5,\n" +
                        "\"name\": \"cherry\",\n" +
                        "\"quantity\": 111 \n" +
                        "}")
                        .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:5,name:cherry}"))
                .andReturn();

    }



}
