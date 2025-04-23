package com.eightynine.eightyninebackend.controller;

import org.springframework.web.bind.annotation.RestController;
import com.eightynine.eightyninebackend.repository.CategoryRepository;
import com.eightynine.eightyninebackend.model.Category;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")

public class CategoriesController {
    
    @Autowired
    private CategoryRepository repository;



    @GetMapping("/getcategories")
   public List<Category> getAll(){
    return repository.findAll();
   }

   @GetMapping("/{id}")
   public  ResponseEntity<Category> getById(@PathVariable Long id){
    return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
   }
    
@PostMapping("/createcategory")
 public Category create(@RequestBody Category category){
    return repository.save(category);
 }

 @PutMapping("updateCategory/{id}")
 public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category updated) {
    return repository.findById(id).map(category -> {
        category.setName(updated.getName());
        return ResponseEntity.ok(repository.save(category));
    }).orElse(ResponseEntity.notFound().build());
}

@DeleteMapping("/{id}")

public ResponseEntity<?> delete(@PathVariable Long id){

    return repository.findById(id).map(category ->{
        repository.delete(category);
        return ResponseEntity.ok().build();
    }).orElse(ResponseEntity.notFound().build());
}

}
