package com.cartappbackend.cartappbackend.services;

import com.cartappbackend.cartappbackend.exceptions.ItemNotFoundException;
import com.cartappbackend.cartappbackend.models.Item;
import com.cartappbackend.cartappbackend.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Item addItem(Item item){
        return itemRepository.save(item);
    }

    public Item getItem(Long id){
        return itemRepository.findById(id).orElseThrow(()-> new ItemNotFoundException(id));
    }

    @Transactional
    public Item updateItem(Long id, Item item){

        Item itemToUpdate = getItem(id);

        itemToUpdate.setName(item.getName());
        itemToUpdate.setSerialNumber(item.getSerialNumber());
        itemToUpdate.setImageUrl(item.getImageUrl());
        itemToUpdate.setDescription(item.getDescription());

        // By using @Transactional annotation we don't need to call the .save() method
        // return itemRepository.save(itemToUpdate);

        return itemToUpdate;

    }

    public Item deleteItem(Long id){

        Item itemToDelete = getItem(id);
        itemRepository.delete(itemToDelete);
        return itemToDelete;

    }

    public List<Item> getItems(){
        return itemRepository.findAll();
    }

}
