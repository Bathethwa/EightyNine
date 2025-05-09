package com.eightynine.eightyninebackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eightynine.eightyninebackend.model.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{

List<Address> getAddressByUser_Id(Long userId);

}
