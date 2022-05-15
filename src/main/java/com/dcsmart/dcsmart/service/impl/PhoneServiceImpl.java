package com.dcsmart.dcsmart.service.impl;

import com.dcsmart.dcsmart.model.Phone;
import com.dcsmart.dcsmart.repository.ClientRepository;
import com.dcsmart.dcsmart.repository.PhoneRepository;
import com.dcsmart.dcsmart.service.PhoneService;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {

    private final ClientRepository clientRepository;
    private final PhoneRepository phoneRepository;

    public PhoneServiceImpl(ClientRepository clientRepository, PhoneRepository phoneRepository) {
        this.clientRepository = clientRepository;
        this.phoneRepository = phoneRepository;
    }

    @Override
    public void save(Phone phone) {

    }

    @Override
    public List<Phone> findAll() {
        return null;
    }

    @Override
    public Phone findById(Long id) {
        return null;
    }

    @Override
    public Phone findByName(String name) {
        return null;
    }

    @Override
    public Phone update(Long id, Phone phone) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
