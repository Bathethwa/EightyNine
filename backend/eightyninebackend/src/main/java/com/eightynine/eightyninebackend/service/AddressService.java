package com.eightynine.eightyninebackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eightynine.eightyninebackend.model.Address;
import com.eightynine.eightyninebackend.model.User;
import com.eightynine.eightyninebackend.repository.AddressRepository;
import com.eightynine.eightyninebackend.repository.UserRepository;

@Service
public class AddressService {

@Autowired
private final AddressRepository addressRepository;
private final  UserRepository userRepository;




public AddressService(AddressRepository addressRepository, UserRepository userRepository) {
    this.addressRepository = addressRepository;
    this.userRepository = userRepository;
}

public List<Address> getAddressforUser(Long userId){

    return addressRepository.getAddressByUser_Id(userId);

}

public Address addAddress(Long userId, Address address){

    User user = userRepository.findById(userId)
                                    .orElseThrow(()-> new RuntimeException("User not found"));
    address.setUser(user);
    return addressRepository.save(address);
}


public Address updateAddress(Address updatedAddress){
    
return addressRepository.save(updatedAddress);
}

public void deleteAddress(Long addressId){
addressRepository.deleteById(addressId);
}

}