package com.sahal.shoppingcart.cart.mapper;

import com.sahal.shoppingcart.cart.dto.ShoppingCartDto;
import com.sahal.shoppingcart.cart.model.ShoppingCart;
import com.sahal.shoppingcart.item.model.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-18T12:31:06+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
@Component
public class CartMapperImpl implements CartMapper {

    @Override
    public ShoppingCartDto entityToDto(ShoppingCart shoppingCart) {
        if ( shoppingCart == null ) {
            return null;
        }

        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();

        shoppingCartDto.setId( shoppingCart.getId() );
        shoppingCartDto.setItemCount( shoppingCart.getItemCount() );
        shoppingCartDto.setGrandTotal( shoppingCart.getGrandTotal() );
        shoppingCartDto.setTotalDiscount( shoppingCart.getTotalDiscount() );
        List<Item> list = shoppingCart.getItemsInCart();
        if ( list != null ) {
            shoppingCartDto.setItemsInCart( new ArrayList<Item>( list ) );
        }

        return shoppingCartDto;
    }

    @Override
    public ShoppingCart dtoToEntity(ShoppingCartDto shoppingCartDto) {
        if ( shoppingCartDto == null ) {
            return null;
        }

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setId( shoppingCartDto.getId() );
        shoppingCart.setItemCount( shoppingCartDto.getItemCount() );
        shoppingCart.setGrandTotal( shoppingCartDto.getGrandTotal() );
        shoppingCart.setTotalDiscount( shoppingCartDto.getTotalDiscount() );
        List<Item> list = shoppingCartDto.getItemsInCart();
        if ( list != null ) {
            shoppingCart.setItemsInCart( new ArrayList<Item>( list ) );
        }

        return shoppingCart;
    }

    @Override
    public List<ShoppingCartDto> entityToDto(List<ShoppingCart> shoppingCartList) {
        if ( shoppingCartList == null ) {
            return null;
        }

        List<ShoppingCartDto> list = new ArrayList<ShoppingCartDto>( shoppingCartList.size() );
        for ( ShoppingCart shoppingCart : shoppingCartList ) {
            list.add( entityToDto( shoppingCart ) );
        }

        return list;
    }

    @Override
    public List<ShoppingCart> dtoToEntity(List<ShoppingCartDto> shoppingCartDtoList) {
        if ( shoppingCartDtoList == null ) {
            return null;
        }

        List<ShoppingCart> list = new ArrayList<ShoppingCart>( shoppingCartDtoList.size() );
        for ( ShoppingCartDto shoppingCartDto : shoppingCartDtoList ) {
            list.add( dtoToEntity( shoppingCartDto ) );
        }

        return list;
    }
}
