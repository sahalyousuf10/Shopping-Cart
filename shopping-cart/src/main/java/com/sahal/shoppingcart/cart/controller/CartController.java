package com.sahal.shoppingcart.cart.controller;

import com.sahal.shoppingcart.cart.dto.ShoppingCartDto;
import com.sahal.shoppingcart.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ShoppingCartDto createEmptyCart(@RequestBody ShoppingCartDto shoppingCartDto){
        ShoppingCartDto createdShoppingCartDto = cartService.createEmptyCart(shoppingCartDto);
        return createdShoppingCartDto;
    }

    @PutMapping("/{cartId}/item/{itemId}/quantity/{quantity}")
    public ShoppingCartDto addItemsToCart(@PathVariable long cartId, @PathVariable long itemId, @PathVariable int quantity) {
        ShoppingCartDto updatedCartDto = cartService.addItemsInCart(cartId, itemId, quantity);
        return updatedCartDto;
    }

    @DeleteMapping("/{cartId}/item/{itemId}")
    public ShoppingCartDto deleteItemsToCart(@PathVariable long cartId, @PathVariable long itemId) {
        ShoppingCartDto updatedCartDto = cartService.deleteItemsInCart(cartId, itemId);
        return updatedCartDto;
    }

    @GetMapping
    public List<ShoppingCartDto> getAllCarts() {
        List<ShoppingCartDto> shoppingCartList = cartService.findAllCarts();
        return shoppingCartList;
    }
}
