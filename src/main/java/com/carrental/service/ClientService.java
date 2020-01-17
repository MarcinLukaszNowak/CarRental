package com.carrental.service;

import com.carrental.crudRepository.ClientRepository;
import com.carrental.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClient(long clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public void deleteClient(long clientId) {
        clientRepository.deleteById(clientId);
    }
}
