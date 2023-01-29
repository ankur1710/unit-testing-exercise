package com.ankur.unittestingexercise.model;

import com.ankur.unittestingexercise.repository.ItemEntityRepository;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Getter
@Setter
@Entity
@Table(name = "ITEM_ENTITY")
@NoArgsConstructor
public class ItemEntity {
    @Id
    private int id;
    private String name;
    private int quantity;
    @Transient
    private double totalValue;

    public ItemEntity(int id,String name, int quantity){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }


}
