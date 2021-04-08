package com.cartappbackend.cartappbackend.exceptions;

import java.text.MessageFormat;

public class ItemAlreadyAssignedToCartException extends RuntimeException{
    public ItemAlreadyAssignedToCartException(Long itemId, Long cartId){
        super(MessageFormat.format("Item with id {0} has already been assigned to cart id: {1}", itemId, cartId));
    }
}
