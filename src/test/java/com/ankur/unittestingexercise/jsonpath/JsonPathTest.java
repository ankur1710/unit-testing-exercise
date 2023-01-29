package com.ankur.unittestingexercise.jsonpath;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {

    @Test
    void testJsonPath(){
        String responseFromService = "[" +
                "{\"id\":1,\"name\":\"apple\",\"quantity\":10,\"totalValue\":10.0},"+
                "{\"id\":2,\"name\":\"banana\",\"quantity\":100,\"totalValue\":200.0},"+
                "{\"id\":3,\"name\":\"orange\",\"quantity\":110,\"totalValue\":330.0},"+
                "{\"id\":4,\"name\":\"PineApple\",\"quantity\":11,\"totalValue\":44.0}"+
                "]";

       DocumentContext context =  JsonPath.parse(responseFromService);
       int length = context.read("$.length()"); // '$' is the json file
       Assertions.assertThat(length).isEqualTo(4);

       List<Integer> ids =  context.read("$..id");
        Assertions.assertThat(ids).hasSize(4)
                .contains(1, 3)
                .allMatch(x -> x>0)
                .allMatch(x -> x<10);

        String banana =  context.read("$.[1]").toString();
       //{id=2, name=banana, quantity=100, totalValue=200.0}
        assertThat(banana).contains("banana")
                .startsWith("{id=2")
                .containsWhitespaces();

        System.out.println(context.read("$.[0:4]").toString());
        // this will return the form index 0 and 1
        //[{"id":1,"name":"apple","quantity":10,"totalValue":10.0},{"id":2,"name":"banana","quantity":100,"totalValue":200.0}]

        System.out.println(context.read("$.[?(@.name=='PineApple')]").toString());
        //this will get me the item with name = pineapple
        //[{"id":4,"name":"PineApple","quantity":11,"totalValue":44.0}]

        System.out.println(context.read("$.[?(@.quantity==110)]").toString());
        //this will get me the item with quantity= 110
        //[{"id":3,"name":"orange","quantity":110,"totalValue":330.0}]


    }
}
