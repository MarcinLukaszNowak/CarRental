package com.carrental.contoller;

import com.carrental.domain.Client;
import com.carrental.dto.ClientDto;
import com.carrental.mapper.ClientMapper;
import com.carrental.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientMapper clientMapper;

    @GetMapping(value = "getAllClients")
    public List<ClientDto> getAllClients() {
        return clientMapper.mapToClientDtoList(clientService.getAllClients());
    }

    @GetMapping(value = "getClient/{id}")
    public ClientDto getClient(@PathVariable("id") long clientId) {
        return clientMapper.mapToClientDto((clientService.getClient(clientId)));
    }

    @PostMapping(value = "addClient")
    public void addClient(@RequestParam String name,
                          @RequestParam String lastName,
                          @RequestParam String email,
                          @RequestParam String phoneNumber) {
        clientService.addClient(name, lastName, email, phoneNumber);
    }

    @PutMapping(value = "updateClient")
    public void updateClient(@RequestBody ClientDto clientDto) {
        clientService.updateClient(clientMapper.mapToClient(clientDto));
    }

    @DeleteMapping(value = "deleteClient/{id}")
    public void deleteClient(@PathVariable("id") long clientId) {
        clientService.deleteClient(clientId);
    }
}
