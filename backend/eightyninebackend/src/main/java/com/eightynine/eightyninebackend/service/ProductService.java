package com.eightynine.eightyninebackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eightynine.eightyninebackend.model.Product;
import com.eightynine.eightyninebackend.repository.ProductsRepository;

@Service
public class ProductService {

@Autowired
 private final ProductsRepository productRepository;

    
    public ProductService(ProductsRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductsByCategories(List<String> categories) {
        return productRepository.findProductsByCategories(
            categories.stream()
                .map(String::toLowerCase)
                .toList(),
            (long) categories.size()
        );
    }
}
