package com.ankur.unittestingexercise.hamcrest;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamCrestMatcherTest {

    @Test
    void hamcrestMatcherTest(){

        List<Integer> numbers = List.of(12,45,23);

        assertThat(numbers,hasSize(3));
        assertThat(numbers,hasItems(12,23));
        assertThat(numbers,everyItem(greaterThan(10)));
        assertThat(numbers,everyItem(lessThan(100)));

        assertThat("",blankOrNullString());
        assertThat("ABCDE",containsString("ABCD"));
        assertThat("ABCDE",startsWith("AB"));
        assertThat("ABCDE",endsWith("DE"));

        //wide variety of matchers.

    }
}
