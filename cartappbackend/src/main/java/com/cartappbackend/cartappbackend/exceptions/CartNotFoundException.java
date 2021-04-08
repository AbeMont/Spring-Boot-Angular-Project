package com.cartappbackend.cartappbackend.exceptions;

import java.text.MessageFormat;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(Long id){
        super(MessageFormat.format("Cart has not been found id: {0}", id));
    }
}
