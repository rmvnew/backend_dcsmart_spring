package com.dcsmart.dcsmart.service;

import com.dcsmart.dcsmart.controller.dto.ClientRequest;
import com.dcsmart.dcsmart.controller.dto.ClientResponse;
import com.dcsmart.dcsmart.model.Client;

import java.util.List;

public interface ClientService {

    void save(ClientRequest client);

    List<ClientResponse> findAll();

    ClientResponse findById(Long id);

    ClientResponse findByName(String name);

    ClientResponse update(Long id, Client client);

    void delete(Long id);


}
