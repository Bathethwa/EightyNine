package com.eightynine.eightyninebackend.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
   

    private  long category_id;
    private String name;

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore// avoid infinite loop
    private Set<Product> products = new HashSet<>();


// getters
    public Set<Product> getProducts() {
        return products;
    }

    public long getId() {
        return category_id;
    }
    public String getName() {
        return name;
    }
// setters
    public void setId(long id) {
        this.category_id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
    

}
