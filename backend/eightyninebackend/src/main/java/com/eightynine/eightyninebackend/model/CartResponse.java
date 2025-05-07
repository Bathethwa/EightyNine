package com.eightynine.eightyninebackend.model;

import java.util.List;

public class CartResponse {
    private Cart cart;
    private List<CartItems> items;
    public CartResponse(Cart cart, List<CartItems> items) {
        this.cart = cart;
        this.items = items;
    }
    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public List<CartItems> getItems() {
        return items;
    }
    public void setItems(List<CartItems> items) {
        this.items = items;
    }

    

}
