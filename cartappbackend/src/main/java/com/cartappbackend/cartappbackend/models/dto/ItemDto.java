package com.cartappbackend.cartappbackend.models.dto;

import com.cartappbackend.cartappbackend.models.Item;

import java.util.Objects;

public class ItemDto {

    private Long id;
    private String name;
    private Long serialNumber;
    private CartInfo cartInfo;
    private String imageUrl;
    private String description;

    public ItemDto() {
    }

    public ItemDto(Long id, String name, Long serialNumber, CartInfo cartInfo, String imageUrl, String description) {
        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
        this.cartInfo = cartInfo;
        this.imageUrl = imageUrl;
        this.description = description;
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

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CartInfo getCartInfo() {
        return cartInfo;
    }

    public void setCartInfo(CartInfo cartInfo) {
        this.cartInfo = cartInfo;
    }

    /////////////
    // DTO Stuff
    ////////////

    public static ItemDto from (Item item){

        ItemDto itemDto = new ItemDto();

        itemDto.setId(item.getId());
        itemDto.setName(item.getName());
        itemDto.setSerialNumber(item.getSerialNumber());
        itemDto.setImageUrl(item.getImageUrl());
        itemDto.setDescription(item.getDescription());

        // By default, the CartInfo is null. If its not null, we add the cart it is assigned too.
        if(Objects.nonNull(item.getCart())){
            itemDto.setCartInfo(CartInfo.from(item.getCart()));
        }

        return itemDto;

    }

}
