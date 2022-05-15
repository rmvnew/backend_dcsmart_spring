package com.dcsmart.dcsmart.controller;


import com.dcsmart.dcsmart.controller.dto.ClientRequest;
import com.dcsmart.dcsmart.controller.dto.ClientResponse;
import com.dcsmart.dcsmart.model.Client;
import com.dcsmart.dcsmart.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public List<ClientResponse> findAll(){
        return clientService.findAll();
    }

    @PostMapping("/")
    public void save(@RequestBody ClientRequest client){
        this.clientService.save(client);
    }

}
