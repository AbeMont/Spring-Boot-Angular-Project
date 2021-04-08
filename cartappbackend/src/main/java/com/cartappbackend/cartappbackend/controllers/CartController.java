package com.cartappbackend.cartappbackend.controllers;

import com.cartappbackend.cartappbackend.models.Cart;
import com.cartappbackend.cartappbackend.models.dto.CartDto;
import com.cartappbackend.cartappbackend.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    CartController(CartService cartService){
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<CartDto> addCart(@RequestBody CartDto cartDto){
        Cart cart = cartService.addCart(Cart.from(cartDto));
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDto> getCart(@PathVariable("id") Long id){
        Cart cartDto = cartService.findCart(id);
        return new ResponseEntity<>(CartDto.from(cartDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartDto> updateCart(@PathVariable("id") Long id, @RequestBody CartDto cartDto){
        Cart cart = cartService.updateCart(id, Cart.from(cartDto));
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CartDto> deleteCart(@PathVariable("id") Long id){
        Cart cart = cartService.deleteCart(id);
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CartDto>> getCarts(){
        List<Cart> carts = cartService.getCarts();
        List<CartDto> cartsDto = carts.stream().map(CartDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(cartsDto, HttpStatus.OK);
    }

    // Add Item to Cart
    @PostMapping("/{cartId}/items/{itemId}/add")
    public ResponseEntity<CartDto> addItemToCart(@PathVariable("cartId") Long cartId, @PathVariable("itemId") Long itemId){
        Cart cart = cartService.addItemToCart(cartId, itemId);
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

    // Delete item from Cart
    @DeleteMapping("/{cartId}/items/{itemId}/remove")
    public ResponseEntity<CartDto> deleteItemFromCart(@PathVariable("cartId") Long cartId, @PathVariable("itemId") Long itemId){
        Cart cart = cartService.deleteItemFromCart(cartId, itemId);
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

}
