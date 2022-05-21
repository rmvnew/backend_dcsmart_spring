package com.dcsmart.dcsmart.service.impl;

import com.dcsmart.dcsmart.controller.dto.request.AddressRequest;
import com.dcsmart.dcsmart.model.Address;
import com.dcsmart.dcsmart.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Override
    public void save(Address addressRequest) {

    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public Address findById(Long id) {
        return null;
    }

    @Override
    public Address findByName(String name) {
        return null;
    }

    @Override
    public Address update(Long id, AddressRequest addressRequest) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
