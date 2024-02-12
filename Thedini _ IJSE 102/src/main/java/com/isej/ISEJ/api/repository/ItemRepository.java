package com.isej.ISEJ.api.repository;

import com.isej.ISEJ.api.Entitiy.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
