package com.eightynine.eightyninebackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_images")
public class Product_Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    private String image_url;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

        

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
 
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public String getImage_url() {
        if (image_url !=null){
            return image_url.replace("\\", "/");
        }
       return null;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
   


}
