package com.eightynine.eightyninebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eightynine.eightyninebackend.model.Product;
import com.eightynine.eightyninebackend.repository.ProductsRepository;
import com.eightynine.eightyninebackend.service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/Products")
@CrossOrigin(origins = "*")
public class ProductsController {

@Autowired
private ProductsRepository repository;

private final ProductService productService;


public ProductsController(ProductService productService){
this.productService = productService;
}


@GetMapping("/getAllProducts")
public List<Product>getAll(){
    return repository.findAll();
}

@GetMapping("/{id}")
public ResponseEntity<Product> getProductByID(@PathVariable Long id){
return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
}


@GetMapping("/Category/{categoryName}")
public List<Product> getProductsByCategoryName(@PathVariable String categoryName){

    return repository.findByCategoryName(categoryName);
}

@GetMapping("/by-categories")
public List<Product> getProductsByCategories(@RequestParam List<String> categories) {
    return productService.getProductsByCategories(categories);
}


public String getMethodName(@RequestParam String param) {
    return new String();
}

@PostMapping("/createProduct")

public Product createProduct(@RequestBody Product product){
    return repository.save(product);
}

@PutMapping("updateProduct/{id}")

public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product updated){

    return repository.findById(id).map(product ->{
        product.setName(updated.getName());
        product.setDescription(updated.getDescription());
        product.setPrice(updated.getPrice());
        product.setStock(updated.getStock());
        product.setCategories(updated.getCategories());
       return ResponseEntity.ok(repository.save(product));
    }).orElse(ResponseEntity.notFound().build());
}


public ResponseEntity<?> delete(@PathVariable Long id){
    return repository.findById(id).map(product->{
        repository.delete(product);
        return ResponseEntity.ok().build();
    }).orElse(ResponseEntity.notFound().build());
}

}
