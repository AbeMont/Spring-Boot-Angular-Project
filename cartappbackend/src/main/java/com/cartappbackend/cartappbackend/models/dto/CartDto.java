package com.cartappbackend.cartappbackend.models.dto;

import com.cartappbackend.cartappbackend.models.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartDto {

    private Long id;
    private String name;
    private String address;
    private List<ItemDto> items  = new ArrayList();

    public CartDto() {
    }

    public CartDto(Long id, String name, String address, List<ItemDto> items) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.items = items;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }

    public static CartDto from(Cart cart){

        CartDto cartDto = new CartDto();

        cartDto.setId(cart.getId());
        cartDto.setName(cart.getName());
        cartDto.setAddress(cart.getAddress());
        cartDto.setItems(cart.getItems().stream().map(ItemDto::from).collect(Collectors.toList()));

        return cartDto;

    }

}
