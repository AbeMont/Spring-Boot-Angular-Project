package com.cartappbackend.cartappbackend.services;

import com.cartappbackend.cartappbackend.exceptions.CartNotFoundException;
import com.cartappbackend.cartappbackend.exceptions.ItemAlreadyAssignedToCartException;
import com.cartappbackend.cartappbackend.models.Cart;
import com.cartappbackend.cartappbackend.models.Item;
import com.cartappbackend.cartappbackend.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ItemService itemService;

    @Autowired
    CartService(CartRepository cartRepository, ItemService itemService){
        this.cartRepository = cartRepository;
        this.itemService = itemService;
    }

    public Cart addCart(Cart cart){
        return cartRepository.save(cart);
    }

    public Cart findCart(Long id){
       return cartRepository.findById(id).orElseThrow(()-> new CartNotFoundException(id));
    }

    public Cart deleteCart(Long id){
        Cart cart = findCart(id);
        cartRepository.delete(cart);
        return cart;
    }

    @Transactional
    public Cart updateCart(Long id, Cart cart){

        Cart cartToEdit = findCart(id);

        cartToEdit.setName(cart.getName());
        cartToEdit.setAddress(cart.getAddress());

        return cartToEdit;
    }

    public List<Cart> getCarts(){
        return cartRepository.findAll();
    }

    // Add Item to Cart
    @Transactional
    public Cart addItemToCart(Long cartId, Long itemId){

        Cart cart = findCart(cartId);
        Item item = itemService.getItem(itemId);

        // If the item cart is not empty, it has a cart with cart_id associated to it.
        // Therefore the item we are trying to add cannot be added to this cart
        if(Objects.nonNull(item.getCart())){
            throw new ItemAlreadyAssignedToCartException(item.getId(), item.getCart().getId());
        }

        cart.addItem(item);
        item.setCart(cart);

       return cart;

    }


    @Transactional
    public Cart deleteItemFromCart(Long cartId, Long itemId){

        Cart cart = findCart(cartId);
        Item item = itemService.getItem(itemId);

        cart.deleteItem(item);

        return cart;

    }

}
