package com.dcsmart.dcsmart.service.impl;

import com.dcsmart.dcsmart.controller.dto.UserRequest;
import com.dcsmart.dcsmart.model.Address;
import com.dcsmart.dcsmart.model.Person;
import com.dcsmart.dcsmart.model.Phone;
import com.dcsmart.dcsmart.model.User;
import com.dcsmart.dcsmart.repository.AddressRepository;
import com.dcsmart.dcsmart.repository.PersonRepository;
import com.dcsmart.dcsmart.repository.PhoneRepository;
import com.dcsmart.dcsmart.repository.UserRepository;
import com.dcsmart.dcsmart.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final PersonRepository personRepository;
    private final PhoneRepository phoneRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public UserServiceImpl(
            PersonRepository personRepository,
            PhoneRepository phoneRepository,
            AddressRepository addressRepository,
            UserRepository userRepository) {
        this.personRepository = personRepository;
        this.phoneRepository = phoneRepository;
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void save(UserRequest user) {

        var currentAddress = new Address();
        currentAddress.setStreet(user.getStreet());
        currentAddress.setDistrict(user.getDistrict());
        currentAddress.setCity(user.getCity());
        currentAddress.setState(user.getState());
        currentAddress.setCountry(user.getCountry());
        currentAddress.setAddress_number(user.getAddress_number());
        currentAddress.setIsActive(true);
        currentAddress.setCreateAt(LocalDateTime.now());
        currentAddress.setUpdateAt(LocalDateTime.now());

        Address addressSaved = this.addressRepository.save(currentAddress);

        var currentClient = new Person();
        currentClient.setName(user.getName());
        currentClient.setRegister(user.getRegister());
        currentClient.setEmail(user.getEmail());
        currentClient.setIsActive(true);
        currentClient.setAddress(addressSaved);
        currentClient.setCreateAt(LocalDateTime.now());
        currentClient.setUpdateAt(LocalDateTime.now());

        Person personSaved = this.personRepository.save(currentClient);

        var currentPhone = new Phone();
        currentPhone.setPhone_number(user.getPhone_number());
        currentPhone.setIsActive(true);
        currentPhone.setPerson(personSaved);
        currentPhone.setCreateAt(LocalDateTime.now());
        currentPhone.setUpdateAt(LocalDateTime.now());
        this.phoneRepository.save(currentPhone);


        var currentUser = new User();
        currentUser.setPassword(user.getPassword());
        currentUser.setPerson(personSaved);
        currentUser.setIsActive(true);
        currentUser.setCreateAt(LocalDateTime.now());
        currentUser.setUpdateAt(LocalDateTime.now());

        this.userRepository.save(currentUser);

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public User update(Long id, UserRequest userRequest) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
