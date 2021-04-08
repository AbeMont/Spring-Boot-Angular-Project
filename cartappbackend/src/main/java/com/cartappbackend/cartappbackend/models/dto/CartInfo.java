package com.cartappbackend.cartappbackend.models.dto;

import com.cartappbackend.cartappbackend.models.Cart;

public class CartInfo {

    private Long id;
    private String name;

    public CartInfo() {
    }

    public CartInfo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static CartInfo from(Cart cart){

        CartInfo cartInfo = new CartInfo();

        cartInfo.setId(cart.getId());
        cartInfo.setName(cart.getName());

        return cartInfo;
    }

}
