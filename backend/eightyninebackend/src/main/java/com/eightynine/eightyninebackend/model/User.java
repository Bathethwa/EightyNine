package com.eightynine.eightyninebackend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")

public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

@Column(name="user_id")
private Long id;
private String name;

@Column(unique = true)
private String email;
@JsonIgnore
private String password_hash;

@Enumerated(EnumType.STRING)
private Role role;

@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
private List<Address> addresses;


public void setId(Long id) {
    this.id = id;
}

public Long getId() {
    return id;
}


public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getPassword_hash() {
    return password_hash;
}

public void setPassword_hash(String password_hash) {
    this.password_hash = password_hash;
}

public Role getRole() {
    return role;
}

public void setRole(Role role) {
    this.role = role;
}

public List<Address> getAddresses() {
    return addresses;
}

public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
}



}
