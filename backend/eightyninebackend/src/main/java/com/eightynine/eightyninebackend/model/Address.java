package com.eightynine.eightyninebackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "addresses")

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="address_id")

    private Long address_id;
    private String address_line;
    private String province;
    private String city;
    private String postal_code;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Long getAddress_id() {
        return address_id;
    }
    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }
    public String getAddress_line() {
        return address_line;
    }
    public void setAddress_line(String address_line) {
        this.address_line = address_line;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPostal_code() {
        return postal_code;
    }
    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    } 


    

}
