package com.dcsmart.dcsmart.service;

import com.dcsmart.dcsmart.model.Phone;

import java.util.List;

public interface PhoneService {

    void save(Phone phone);

    List<Phone> findAll();

    Phone findById(Long id);

    Phone findByName(String name);

    Phone update(Long id, Phone phone);

    void delete(Long id);


}
