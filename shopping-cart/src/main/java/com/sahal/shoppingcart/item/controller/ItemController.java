package com.sahal.shoppingcart.item.controller;

import com.sahal.shoppingcart.cart.service.CartService;
import com.sahal.shoppingcart.item.model.Item;
import com.sahal.shoppingcart.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        Item createdItem = itemService.createItem(item);
        return createdItem;
    }

    @GetMapping
    public List<Item> getItems() {
        List<Item> itemList = itemService.getAllItems();
        return itemList;
    }
}
