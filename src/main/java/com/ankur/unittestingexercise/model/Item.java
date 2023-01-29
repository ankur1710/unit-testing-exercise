package com.ankur.unittestingexercise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Item {
    int id;
    String name;
}
