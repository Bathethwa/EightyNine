package com.eightynine.eightyninebackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.eightynine.eightyninebackend.model.CartItems;

public interface CartItemRepository extends JpaRepository<CartItems,Long> {

    //Find all items in a users's active cart
    @Query("SELECT ci FROM CartItems ci "+
           "JOIN ci.cart c " +
           "JOIN ci.product p "+
           "WHERE c.user.id= :userId AND c.isCheckedOut = false")
           List<CartItems> findItemsInActiveCartByUserId(@Param("userId") long userId);
           
    List<CartItems> findCartByid(Long cartId);
}
