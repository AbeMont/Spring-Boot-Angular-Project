package com.cartappbackend.cartappbackend.models;

import com.cartappbackend.cartappbackend.models.dto.ItemDto;

import javax.persistence.*;

@Entity
@Table(name = "item_list")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long serialNumber;
    private String imageUrl;
    private String description;
    @ManyToOne
    private Cart cart;

    public Item() {
    }

    public Item(Long id, String name, Long serialNumber, Cart cart, String imageUrl, String description) {
        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
        this.imageUrl = imageUrl;
        this.description = description;
        this.cart = cart;
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public static Item from(ItemDto itemDto){

        Item item = new Item();

        item.setId(itemDto.getId());
        item.setName(itemDto.getName());
        item.setSerialNumber(itemDto.getSerialNumber());
        item.setImageUrl(itemDto.getImageUrl());
        item.setDescription(itemDto.getDescription());

        return item;

    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serialNumber=" + serialNumber +
                ", cart=" + cart +
                '}';
    }
}
