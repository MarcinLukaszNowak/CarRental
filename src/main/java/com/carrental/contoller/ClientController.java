package com.carrental.contoller;

import com.carrental.dto.ClientDto;
import com.carrental.mapper.ClientMapper;
import com.carrental.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(value = "addClient", consumes = APPLICATION_JSON_VALUE)
    public void addClient(@RequestBody ClientDto clientDto, String password) {
        clientService.saveClient(clientMapper.mapToClient(clientDto));
    }

    @PutMapping(value = "updateClient")
    public void updateClient(@RequestBody ClientDto clientDto) {
        clientService.saveClient(clientMapper.mapToClient(clientDto));
    }

    @DeleteMapping(value = "deleteClient/{id}")
    public void deleteClient(@PathVariable("id") long clientId) {
        clientService.deleteClient(clientId);
    }
}
