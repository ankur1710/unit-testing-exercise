package com.ankur.unittestingexercise.repository;

import com.ankur.unittestingexercise.model.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemEntityRepository extends JpaRepository<ItemEntity, Integer> {
}
