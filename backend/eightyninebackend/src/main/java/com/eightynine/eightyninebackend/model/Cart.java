package com.eightynine.eightyninebackend.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="cart")
public class Cart {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="cart_id")
private long id;
private LocalDateTime created_at;
private LocalDateTime updated_at;
private boolean is_checked_out;

@OneToMany()
@JoinColumn(name="user_id")
private User user;

@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
private List<CartItems> cartItems= new ArrayList<>();


public long getId() {
    return id;
}
public void setId(long id) {
    this.id = id;
}
public LocalDateTime getCreated_at() {
    return created_at;
}
public void setCreated_at(LocalDateTime created_at) {
    this.created_at = created_at;
}
public LocalDateTime getUpdated_at() {
    return updated_at;
}
public void setUpdated_at(LocalDateTime updated_at) {
    this.updated_at = updated_at;
}
public boolean getIs_checked_out() {
    return is_checked_out;
}
public void setIs_checked_out(boolean is_checked_out) {
    this.is_checked_out = is_checked_out;
}

public List<CartItems> getCartItems() {
    return cartItems;
}
public void setCartItems(List<CartItems> cartItems) {
    this.cartItems = cartItems;
}

public User getUser() {
    return user;
}
public void setUser(User user) {
    this.user = user;
}


}
