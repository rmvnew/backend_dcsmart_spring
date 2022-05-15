package com.dcsmart.dcsmart.service.impl;

import com.dcsmart.dcsmart.controller.dto.ClientRequest;
import com.dcsmart.dcsmart.controller.dto.ClientResponse;
import com.dcsmart.dcsmart.model.Client;
import com.dcsmart.dcsmart.model.Phone;
import com.dcsmart.dcsmart.repository.ClientRepository;
import com.dcsmart.dcsmart.repository.PhoneRepository;
import com.dcsmart.dcsmart.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {


    private final ClientRepository clientRepository;
    private final PhoneRepository phoneRepository;

    public ClientServiceImpl(ClientRepository clientRepository, PhoneRepository phoneRepository) {
        this.clientRepository = clientRepository;
        this.phoneRepository = phoneRepository;
    }

    @Override
    public void save(ClientRequest client) {

        var currentClient = new Client();
        currentClient.setName(client.getName());
        currentClient.setRegister(client.getRegister());
        currentClient.setEmail(client.getEmail());
        currentClient.setIsActive(true);

        Client clientSaved = this.clientRepository.save(currentClient);

        Phone phone = new Phone();
        phone.setNumber(client.getPhone());
        phone.setIsActive(true);
        phone.setClient(clientSaved);
        this.phoneRepository.save(phone);

    }

    @Override
    public List<ClientResponse> findAll() {
        var clients = clientRepository.findAll();
        return clients
                .stream()
//                .map((cli) -> ClientResponse.converter(cli))
                .map(ClientResponse::converter)
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponse findById(Long id) {
        return ClientResponse.converter(clientRepository.getById(id));
    }

    @Override
    public ClientResponse findByName(String name) {
        return null;
    }

    @Override
    public ClientResponse update(Long id, Client client) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
