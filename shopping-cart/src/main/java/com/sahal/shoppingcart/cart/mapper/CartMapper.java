package com.sahal.shoppingcart.cart.mapper;

import com.sahal.shoppingcart.cart.dto.ShoppingCartDto;
import com.sahal.shoppingcart.cart.model.ShoppingCart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {

    ShoppingCartDto entityToDto(ShoppingCart shoppingCart);
    ShoppingCart dtoToEntity(ShoppingCartDto shoppingCartDto);
    List<ShoppingCartDto> entityToDto(List<ShoppingCart> shoppingCartList);
    List<ShoppingCart> dtoToEntity(List<ShoppingCartDto> shoppingCartDtoList);
}
