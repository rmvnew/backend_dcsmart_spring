package com.dcsmart.dcsmart.service.impl;

import com.dcsmart.dcsmart.controller.dto.PersonRequest;
import com.dcsmart.dcsmart.controller.dto.PersonResponse;
import com.dcsmart.dcsmart.model.Address;
import com.dcsmart.dcsmart.model.Person;
import com.dcsmart.dcsmart.model.Phone;
import com.dcsmart.dcsmart.repository.AddressRepository;
import com.dcsmart.dcsmart.repository.PersonRepository;
import com.dcsmart.dcsmart.repository.PhoneRepository;
import com.dcsmart.dcsmart.service.PersonService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {


    private final PersonRepository personRepository;
    private final PhoneRepository phoneRepository;
    private final AddressRepository addressRepository;

    public PersonServiceImpl(
            PersonRepository personRepository,
            PhoneRepository phoneRepository,
            AddressRepository addressRepository
    ) {
        this.personRepository = personRepository;
        this.phoneRepository = phoneRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void save(PersonRequest client) {

        var currentAddress = new Address();
        currentAddress.setStreet(client.getStreet());
        currentAddress.setDistrict(client.getDistrict());
        currentAddress.setCity(client.getCity());
        currentAddress.setState(client.getState());
        currentAddress.setCountry(client.getCountry());
        currentAddress.setAddress_number(client.getAddress_number());
        currentAddress.setIsActive(true);
        currentAddress.setCreateAt(LocalDateTime.now());
        currentAddress.setUpdateAt(LocalDateTime.now());

        Address addressSaved = this.addressRepository.save(currentAddress);

        var currentClient = new Person();
        currentClient.setName(client.getName());
        currentClient.setRegister(client.getRegister());
        currentClient.setEmail(client.getEmail());
        currentClient.setIsActive(true);
        currentClient.setAddress(addressSaved);
        currentClient.setCreateAt(LocalDateTime.now());
        currentClient.setUpdateAt(LocalDateTime.now());

        Person personSaved = this.personRepository.save(currentClient);

        var currentPhone = new Phone();
        currentPhone.setPhone_number(client.getPhone_number());
        currentPhone.setIsActive(true);
        currentPhone.setPerson(personSaved);
        currentPhone.setCreateAt(LocalDateTime.now());
        currentPhone.setUpdateAt(LocalDateTime.now());
        this.phoneRepository.save(currentPhone);



    }

    @Override
    public List<PersonResponse> findAll() {
        var clients = personRepository.findAll();
        return clients
                .stream()
//                .map((cli) -> ClientResponse.converter(cli))
                .map(PersonResponse::converter)
                .collect(Collectors.toList());
    }

    @Override
    public PersonResponse findById(Long id) {
        return PersonResponse.converter(personRepository.getById(id));
    }

    @Override
    public PersonResponse findByName(String name) {
        return null;
    }

    @Override
    public PersonResponse update(Long id, Person person) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
