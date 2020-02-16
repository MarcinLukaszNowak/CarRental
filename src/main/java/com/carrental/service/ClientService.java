package com.carrental.service;

import com.carrental.crudRepository.ClientRepository;
import com.carrental.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public void addClient(String clientName, String clientLastName, String clientEmail, String clientPhoneNumber) {
        Date clientRegistrationDate = new Date();
        Client client = new Client(clientName, clientLastName, clientEmail, clientPhoneNumber, clientRegistrationDate);
        clientRepository.save(client);
    }

    public void updateClient(Client client) {
        clientRepository.save(client);
    }

    public void deleteClient(long clientId) {
        clientRepository.deleteById(clientId);
    }
}
