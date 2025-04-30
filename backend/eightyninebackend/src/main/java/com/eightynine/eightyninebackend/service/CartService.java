package com.eightynine.eightyninebackend.service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import com.eightynine.eightyninebackend.model.Cart;
import com.eightynine.eightyninebackend.model.CartItems;
import com.eightynine.eightyninebackend.model.Product;
import com.eightynine.eightyninebackend.model.User;
import com.eightynine.eightyninebackend.repository.CartItemRepository;
import com.eightynine.eightyninebackend.repository.CartRepository;
import com.eightynine.eightyninebackend.repository.ProductsRepository;
import com.eightynine.eightyninebackend.repository.UserRepository;

@Service
public class CartService {

    
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository; 
    private final ProductsRepository productRepository; 


    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository,
            UserRepository userRepository, ProductsRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    
    public List<CartItems> viewCart(Long userId){
        return cartItemRepository.findItemsInActiveCartByUserId(userId);
    }
    // Get or create an active cart for the user
    public Cart getOrCreateActiveCart(Long userId){
        return this.cartRepository.findByUserIdAndIsCheckedOutFalse(userId)
                                  .orElseGet(()-> {
                                      User user = userRepository.findById(userId)
                                                            .orElseThrow(()-> new RuntimeException("User notFound"));
                                      Cart  newCart =  new Cart();
                                      newCart.setUser(user);
                                      newCart.setIs_checked_out(false);
                                      newCart.setCreated_at(LocalDateTime.now());
                                      newCart.setUpdated_at(LocalDateTime.now());
                                      return cartRepository.save(newCart);
                                  });
    }


    public void addToCart(Long userId, Long productId){

        Cart cart = getOrCreateActiveCart(userId);
        Product product = productRepository.findById(productId)
                                            .orElseThrow(()-> new RuntimeException("Product not found"));

        CartItems item = new CartItems(productId, cart, product, 1);
        cartItemRepository.save(item);

    }

  

    public void removeItem(Long itemId){
        this.cartItemRepository.deleteById(itemId);
    }



    public void checkoutCart(Long userId) {
        Cart cart = cartRepository.findByUserIdAndIsCheckedOutFalse(userId)
                .orElseThrow(() -> new RuntimeException("Active cart not found"));

        cart.setIs_checked_out(true);
        cart.setUpdated_at(LocalDateTime.now());
        cartRepository.save(cart);
    }
}
