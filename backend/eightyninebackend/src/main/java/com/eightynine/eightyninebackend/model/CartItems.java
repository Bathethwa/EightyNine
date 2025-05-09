package com.eightynine.eightyninebackend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "cart_items")
public class CartItems {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@ManyToOne
@JoinColumn(name = "cart_id")
@JsonIgnore
private Cart cart;



@ManyToOne
@JoinColumn(name ="product_id")
private Product product;

private int quantity;



public CartItems() {}

public CartItems(Long id, Cart cart, Product product, int quantity) {
    this.id = id;
    this.cart = cart;
    this.product = product;
    this.quantity = quantity;
}


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }


    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
 

}
