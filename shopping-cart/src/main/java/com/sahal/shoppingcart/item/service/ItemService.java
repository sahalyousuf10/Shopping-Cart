package com.sahal.shoppingcart.item.service;

import com.sahal.shoppingcart.item.model.Item;
import com.sahal.shoppingcart.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(Item item) {
        Item createdItem = itemRepository.save(item);
        return item;
    }

    public List<Item> getAllItems() {
        List<Item> itemList = itemRepository.findAll();
        return itemList;
    }
}
