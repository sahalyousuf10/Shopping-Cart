package com.sahal.shoppingcart.unit.test;

import com.sahal.shoppingcart.cart.dto.ShoppingCartDto;
import com.sahal.shoppingcart.cart.mapper.CartMapper;
import com.sahal.shoppingcart.cart.model.ShoppingCart;
import com.sahal.shoppingcart.cart.repository.CartRepository;
import com.sahal.shoppingcart.cart.service.CartService;
import com.sahal.shoppingcart.item.model.Item;
import com.sahal.shoppingcart.item.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class TestService {

    @Mock
    private CartMapper cartMapper;

    @Mock
    private CartRepository cartRepository;

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private CartService cartService;


    private ShoppingCart mockEmptyCart;
    private ShoppingCart mockCart;
    private ShoppingCartDto mockCartDto;
    private List<ShoppingCart> shoppingCartList = new ArrayList<>();
    List<Item> itemList = new ArrayList<>();
    private Item mockItem;

    @Before
    public void createMockObjects(){
        mockCart = new ShoppingCart();
        mockEmptyCart = new ShoppingCart();
        mockItem = new Item(
                1L,
                0,
                101L,
                "Red",
                400,
                50,
                shoppingCartList);
        itemList.add(mockItem);
        mockCart = new ShoppingCart(
                1L,
                1,
                400,
                50,
                itemList);
        shoppingCartList.add(mockCart);
        mockCartDto = new ShoppingCartDto(
                1L,
                1,
                400,
                50,
                itemList);
    }

    @Test
    public void testAddItemsInCart(){
        mockEmptyCart.setId(1L);
        when(cartRepository.findById(1L)).thenReturn(Optional.ofNullable(mockEmptyCart));
        when(itemRepository.findById(1L)).thenReturn(Optional.ofNullable(mockItem));
        when(cartRepository.save(ArgumentMatchers.any(ShoppingCart.class))).thenReturn(mockCart);
        ShoppingCartDto shoppingCartDto = cartService.addItemsInCart(1L, 1L, 1);
        when(cartMapper.entityToDto(any(ShoppingCart.class))).thenReturn(shoppingCartDto);
        log.info(String.valueOf(shoppingCartDto));
        //Assert.assertEquals(shoppingCartDto,mockCartDto);
    }
}
