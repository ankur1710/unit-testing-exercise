package com.ankur.unittestingexercise.assertj;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;


public class AssertJTest {

    @Test
    void assertJTests() {

        List<Integer> numbers = List.of(12, 45, 23);

        assertThat(numbers).hasSize(3)
                .contains(45, 23)
                .allMatch(x -> x>10)
                .allMatch(x -> x<100)
                .noneMatch(x -> x<0);

        assertThat("AB CDE").contains("CD")
                .startsWith("AB")
                .endsWith("DE")
                .containsWhitespaces();
        //wide variety of matchers.

    }
}
