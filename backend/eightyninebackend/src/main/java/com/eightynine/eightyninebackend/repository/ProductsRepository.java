package com.eightynine.eightyninebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eightynine.eightyninebackend.model.Product;

@Repository
public interface ProductsRepository extends JpaRepository<Product,Long>  {}
