package com.eightynine.eightyninebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eightynine.eightyninebackend.model.Product;
import com.eightynine.eightyninebackend.repository.ProductsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/Products")
@CrossOrigin(origins = "*")
public class ProductsController {

@Autowired
private ProductsRepository repository;


@GetMapping("/getAllProducts")
public List<Product>getAll(){
    return repository.findAll();
}

@GetMapping("/{id}")
public ResponseEntity<Product> getProductByID(@PathVariable Long id){
return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
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
