package com.cartappbackend.cartappbackend.exceptions;

import java.text.MessageFormat;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(long id){
        super(MessageFormat.format("Item not found for id: {0}", id));
    }

}
