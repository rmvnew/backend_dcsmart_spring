package com.dcsmart.dcsmart.service;

import com.dcsmart.dcsmart.controller.dto.request.PersonRequest;
import com.dcsmart.dcsmart.controller.dto.response.PersonResponse;
import com.dcsmart.dcsmart.model.Person;

import java.util.List;

public interface PersonService {

    void save(PersonRequest client);

    List<PersonResponse> findAll();

    PersonResponse findById(Long id);

    PersonResponse findByName(String name);

    PersonResponse update(Long id, Person person);

    void delete(Long id);


}
