package com.eightynine.eightyninebackend.controller;

import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eightynine.eightyninebackend.model.Address;
import com.eightynine.eightyninebackend.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/Address")
@CrossOrigin("*")
public class AddressController {
    
private AddressService addressService;

public AddressController(AddressService addressService) {
    this.addressService = addressService;
}

@GetMapping("/getAddress")
public List<Address> getUserAddress(@RequestParam Long userId) {
    return addressService.getAddressforUser(userId);
}

@PostMapping("/createAddress")
public Address createAddress(@RequestBody Address newAddress,Long userId) {
    return addressService.addAddress(userId, newAddress);
}

@PutMapping("/updateAddress")
public Address updatAddress(@RequestBody Address Address) {
    return addressService.updateAddress(Address);
}


@DeleteMapping("/{id}")
public void deleteAddress(@PathVariable Long id){
  addressService.deleteAddress(id);
}



}
