package com.sahal.shoppingcart.cart.service;

import com.sahal.shoppingcart.cart.dto.ShoppingCartDto;
import com.sahal.shoppingcart.cart.mapper.CartMapper;
import com.sahal.shoppingcart.cart.model.ShoppingCart;
import com.sahal.shoppingcart.cart.repository.CartRepository;
import com.sahal.shoppingcart.item.model.Item;
import com.sahal.shoppingcart.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CartMapper cartMapper;

    public ShoppingCartDto createEmptyCart(ShoppingCartDto shoppingCartDto) {
        ShoppingCart shoppingCart = cartMapper.dtoToEntity(shoppingCartDto);
        ShoppingCart createdShoppingCart = cartRepository.save(shoppingCart);
        ShoppingCartDto createdShoppingCartDto = cartMapper.entityToDto(createdShoppingCart);
        return createdShoppingCartDto;
    }

    public ShoppingCartDto addItemsInCart(long cartId, long itemId, int quantity) {
        int count = 0;
        double totalPrice;
        double grandTotal = 0;
        double totalDiscount = 0;
        double price;
        double discount;
        double itemDiscount;
        int itemQuantity;
        ShoppingCart shoppingCart = cartRepository.findById(cartId).get();
        Item item = itemRepository.findById(itemId).get();
        item.setQuantity(quantity);
        shoppingCart.getItemsInCart().add(item);
        List<Item> itemList;
        itemList = shoppingCart.getItemsInCart();
        for (Item items : itemList) {
            itemQuantity = items.getQuantity();
            count = count + itemQuantity;
            price = items.getPrice();
            totalPrice = price * itemQuantity;
            grandTotal = grandTotal + totalPrice;
            discount = items.getDiscount();
            itemDiscount = discount * itemQuantity;
            totalDiscount = totalDiscount + itemDiscount;
        }
        shoppingCart.setItemCount(count);
        shoppingCart.setGrandTotal(grandTotal);
        shoppingCart.setTotalDiscount(totalDiscount);
        ShoppingCart updatedCart = cartRepository.save(shoppingCart);
        ShoppingCartDto updatedCartDto = cartMapper.entityToDto(updatedCart);
        return updatedCartDto;
    }

    public List<ShoppingCartDto> findAllCarts() {
        List<ShoppingCart> shoppingCartList = cartRepository.findAll();
        List<ShoppingCartDto> shoppingCartDtoList = cartMapper.entityToDto(shoppingCartList);
        return shoppingCartDtoList;
    }

    public ShoppingCartDto deleteItemsInCart(long cartId, long itemId) {
        int count = 0;
        double totalPrice;
        double grandTotal = 0;
        double totalDiscount = 0;
        double price;
        double discount;
        double itemDiscount;
        int itemQuantity;
        ShoppingCart shoppingCart = cartRepository.findById(cartId).get();
        Item item = itemRepository.findById(itemId).get();
        shoppingCart.getItemsInCart().remove(item);
        List<Item> itemList;
        itemList = shoppingCart.getItemsInCart();
        for (Item items : itemList) {
            itemQuantity = items.getQuantity();
            count = count + itemQuantity;
            price = items.getPrice();
            totalPrice = price * itemQuantity;
            grandTotal = grandTotal + totalPrice;
            discount = items.getDiscount();
            itemDiscount = discount * itemQuantity;
            totalDiscount = totalDiscount + itemDiscount;
        }
        shoppingCart.setItemCount(count);
        shoppingCart.setGrandTotal(grandTotal);
        shoppingCart.setTotalDiscount(totalDiscount);
        ShoppingCart updatedCart = cartRepository.save(shoppingCart);
        ShoppingCartDto updatedCartDto = cartMapper.entityToDto(updatedCart);
        return updatedCartDto;
    }
}
