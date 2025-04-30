package com.eightynine.eightyninebackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eightynine.eightyninebackend.model.Cart;

public interface CartRepository extends JpaRepository<Cart,Long> {

    Optional<Cart> findByUserIdAndIsCheckedOutFalse(Long userId);
}
