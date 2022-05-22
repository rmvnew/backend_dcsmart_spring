package com.dcsmart.dcsmart.service.impl;

import com.dcsmart.dcsmart.controller.dto.request.UserRequest;
import com.dcsmart.dcsmart.controller.dto.response.UserResponse;
import com.dcsmart.dcsmart.enums.ErrorsMsg;
import com.dcsmart.dcsmart.exception.*;
import com.dcsmart.dcsmart.model.Address;
import com.dcsmart.dcsmart.model.Person;
import com.dcsmart.dcsmart.model.Phone;
import com.dcsmart.dcsmart.model.User;
import com.dcsmart.dcsmart.repository.*;
import com.dcsmart.dcsmart.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private final PersonRepository personRepository;
    private final PhoneRepository phoneRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public UserServiceImpl(
            PersonRepository personRepository,
            PhoneRepository phoneRepository,
            AddressRepository addressRepository,
            UserRepository userRepository, ProfileRepository profileRepository) {
        this.personRepository = personRepository;
        this.phoneRepository = phoneRepository;
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public void save(UserRequest user) {

        var userRegistered = this.userRepository.findByName(user.getName())
                .isPresent();

        if(userRegistered){
            throw new UserIsRegisteredException(String.format("Usuário com nome %s já está cadastrado",user.getName()));
        }

        var currentAddress = new Address();
        currentAddress.setZipCode(user.getZip_code());
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
        currentUser.setProfile(this.profileRepository.getById(user.getProfile_id()));
        currentUser.setIsActive(true);
        currentUser.setCreateAt(LocalDateTime.now());
        currentUser.setUpdateAt(LocalDateTime.now());

        this.userRepository.save(currentUser);

    }

    @Override
    public List<UserResponse> findAll() {

        var user = this.userRepository.findAllActives();
        return user.stream().map(UserResponse::converter).collect(Collectors.toList());
    }

    @Override
    public UserResponse findById(Long id) {
        return UserResponse.converter(this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
//                        String.format("User com id %d não existe",id)
                        ErrorsMsg.USER_NF.getCode()
                                +" - "+ ErrorsMsg.USER_NF.getMessage()
                )));
    }

    @Override
    public UserResponse findByName(String name) {

        User user = this.userRepository.findByName(name)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("User com name %s não existe",name)
                ));


        return UserResponse.converter(user);
    }

    @Override
    public UserResponse update(Long id, UserRequest user) {

        boolean isActive = this.userRepository.findInactive(id).isEmpty();

        if(!isActive){
            throw new UserNotFoundException(String.format("Usuário com id $d não encontrado",id));
        }

        User userRegistered = this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        ErrorsMsg.USER_E.getCode()
                                +" - "+ ErrorsMsg.USER_E.getMessage()
                ));

        Person personRegistered = this.personRepository.findById(userRegistered.getPerson().getPersonId())
                .orElseThrow(() -> new PersonNotFoundException(
                        String.format("Person com id %d não existe",userRegistered.getPerson().getPersonId())
                ));

        Address addressRegistered = this.addressRepository.findById(personRegistered.getAddress().getAddressId())
                .orElseThrow(() -> new AddressNotFoundException(
                        String.format("Address com id %d não existe",personRegistered.getAddress().getAddressId())
                ));

        Phone phoneRegistered = this.phoneRepository.findByPerson(personRegistered.getPersonId())
                .orElseThrow(() -> new PhoneNotFoundException(
                        String.format("Phone com id %d não existe",personRegistered.getPersonId())
                ));


        addressRegistered.setZipCode(user.getZip_code());
        addressRegistered.setStreet(user.getStreet());
        addressRegistered.setDistrict(user.getDistrict());
        addressRegistered.setCity(user.getCity());
        addressRegistered.setState(user.getState());
        addressRegistered.setCountry(user.getCountry());
        addressRegistered.setAddress_number(user.getAddress_number());
        addressRegistered.setIsActive(true);
        addressRegistered.setUpdateAt(LocalDateTime.now());

        Address addressSaved = this.addressRepository.save(addressRegistered);


        personRegistered.setName(user.getName());
        personRegistered.setRegister(user.getRegister());
        personRegistered.setEmail(user.getEmail());
        personRegistered.setIsActive(true);
        personRegistered.setAddress(addressSaved);
        personRegistered.setUpdateAt(LocalDateTime.now());

        Person personSaved = this.personRepository.save(personRegistered);


        phoneRegistered.setPhone_number(user.getPhone_number());
        phoneRegistered.setIsActive(true);
        phoneRegistered.setPerson(personSaved);
        phoneRegistered.setUpdateAt(LocalDateTime.now());
        this.phoneRepository.save(phoneRegistered);



        userRegistered.setPassword(user.getPassword());
        userRegistered.setPerson(personSaved);
        userRegistered.setProfile(this.profileRepository.getById(user.getProfile_id()));
        userRegistered.setIsActive(true);
        userRegistered.setUpdateAt(LocalDateTime.now());

        this.userRepository.save(userRegistered);

        return this.findById(id);
    }

    @Override
    public void delete(Long id) {

        User userSaved = this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("User com id %d não existe",id)
                ));


        if(userSaved.getIsActive()){
            userSaved.setIsActive(false);
        }else{
            throw new ItemInactiveException(String.format("%s is already inactive",userSaved.getPerson().getName()));
        }
        userSaved.setUpdateAt(LocalDateTime.now(ZoneOffset.UTC));

        this.userRepository.save(userSaved);

    }
}
