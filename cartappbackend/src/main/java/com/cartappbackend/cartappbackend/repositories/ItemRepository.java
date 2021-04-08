package com.cartappbackend.cartappbackend.repositories;

import com.cartappbackend.cartappbackend.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
