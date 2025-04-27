package com.eightynine.eightyninebackend.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="product_id")

    private Long product_id;
    private String name;
    private String description;
    private double price;
    private int stock;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product_Image> images = new ArrayList<>();
    


@ManyToMany
@JoinTable(
name = "product_categories",
joinColumns = @JoinColumn(name = "product_id"),
inverseJoinColumns = @JoinColumn(name = "category_id")
)
private Set<Category> categories = new HashSet<>();

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }
    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public Set<Category> getCategories() {
        return categories;
    }
    public List<Product_Image> getImages() {
        return images;
    }
    public void setImages(List<Product_Image> images) {
        this.images = images;
    }



}
