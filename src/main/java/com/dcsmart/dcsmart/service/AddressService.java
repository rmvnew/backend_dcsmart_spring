package com.dcsmart.dcsmart.service;


import com.dcsmart.dcsmart.controller.dto.AddressRequest;
import com.dcsmart.dcsmart.model.Address;

import java.util.List;

public interface AddressService {
    void save(Address addressRequest);

    List<Address> findAll();

    Address findById(Long id);

    Address findByName(String name);

    Address update(Long id, AddressRequest addressRequest);

    void delete(Long id);
}
