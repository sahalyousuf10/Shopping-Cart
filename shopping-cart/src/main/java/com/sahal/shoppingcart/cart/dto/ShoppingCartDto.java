package com.sahal.shoppingcart.cart.dto;

import com.sahal.shoppingcart.item.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDto {

    private long id;
    private int itemCount;
    private double grandTotal;
    private double totalDiscount;
    private List<Item> itemsInCart = new ArrayList<>();
}
