package com.eightynine.eightyninebackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.eightynine.eightyninebackend.model.Product;

@Repository
public interface ProductsRepository extends JpaRepository<Product,Long>  {
    @Query("SELECT p FROM Product p JOIN p.categories c WHERE LOWER(c.name) = LOWER(:categoryName)")
    List<Product> findByCategoryName(@Param("categoryName")String categoryName);

    @Query("SELECT DISTINCT p FROM Product p JOIN p.categories c WHERE LOWER(c.name) IN :categories GROUP BY p HAVING COUNT(DISTINCT c.name) = :categoryCount")
    List<Product> findProductsByCategories(@Param("categories") List<String> categories, @Param("categoryCount") long categoryCount);

}

