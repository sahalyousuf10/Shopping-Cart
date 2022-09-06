package com.sahal.shoppingcart.item.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sahal.shoppingcart.cart.model.ShoppingCart;
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
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantity;
    private long upc;
    private String color;
    private double price;
    private double discount;

    @JsonIgnore
    @ManyToMany(mappedBy = "itemsInCart")
    private List<ShoppingCart> carts = new ArrayList<>();
}
