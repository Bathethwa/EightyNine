package com.eightynine.eightyninebackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eightynine.eightyninebackend.model.Cart;
import com.eightynine.eightyninebackend.model.CartItems;
import com.eightynine.eightyninebackend.service.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/Cart")
@CrossOrigin("*")
public class CartController {

private CartService cartService;

public CartController( CartService cartService) {
    this.cartService = cartService;
}


@GetMapping("/getCart/{id}")
public Cart getOrCreatCart(@PathVariable("id") Long userId){
return this.cartService.getOrCreateActiveCart(userId);
}


@GetMapping("/getCartItems")
public List<CartItems> getCartItems(@RequestParam Long userId) {
    return this.cartService.viewCart(userId);
}

@PostMapping("/addToCart")
public void postMethodName(@RequestParam  Long userid,@RequestParam Long productId) {
    this.cartService.addToCart(userid,productId);
}

@PostMapping("/removeFromCart/{itemid}")
public void removeItem(@PathVariable Long itemid) {

     this.cartService.removeItem(itemid);;
}

@DeleteMapping("/checkOutCart/{itemid}")
public void checkOutCart(@PathVariable Long itemid) {

     this.cartService.checkoutCart(itemid);
}


}
