package com.cartappbackend.cartappbackend.models;

import com.cartappbackend.cartappbackend.models.dto.CartDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart_list")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private List<Item> items  = new ArrayList();

    public Cart() {
    }

    public Cart(Long id, String name, String address, List<Item> items) {
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    /////////////////////
    // Add/Remove Items
    ////////////////////

    public void addItem(Item item){
        this.items.add(item);
    }

    public void deleteItem(Item item){
        this.items.remove(item);
    }

    /////////////
    // DTO Stuff
    ////////////

    public static Cart from(CartDto cartDto){

        Cart cart = new Cart();

        cart.setName(cartDto.getName());
        cart.setAddress(cartDto.getAddress());

        return cart;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", items=" + items +
                '}';
    }
}
