package com.sahal.shoppingcart.cart.model;

import com.sahal.shoppingcart.item.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int itemCount;
    private double grandTotal;
    private double totalDiscount;

    @ManyToMany
    @JoinTable(
            name = "items_in_cart",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> itemsInCart = new ArrayList<>();
}
