package com.cartappbackend.cartappbackend.repositories;

import com.cartappbackend.cartappbackend.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
