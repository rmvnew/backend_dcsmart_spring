package com.dcsmart.dcsmart.controller;


import com.dcsmart.dcsmart.controller.dto.PersonRequest;
import com.dcsmart.dcsmart.controller.dto.PersonResponse;
import com.dcsmart.dcsmart.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public List<PersonResponse> findAll(){
        return personService.findAll();
    }

    @PostMapping("/")
    public void save(@RequestBody PersonRequest client){
        this.personService.save(client);
    }

}
