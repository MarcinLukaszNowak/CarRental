package com.carrental.mapper;

import com.carrental.domain.Client;
import com.carrental.domain.Rental;
import com.carrental.dto.ClientDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    public Client mapToClient(ClientDto clientDto) {
        return new Client(
                clientDto.getClientId(),
                clientDto.getClientFirstName(),
                clientDto.getClientLastName(),
                clientDto.getClientEmail(),
                clientDto.getClientPhoneNumber(),
                clientDto.getClientRegistrationDate(),
                new ArrayList<>()
        );
    }

    public ClientDto mapToClientDto(Client client) {
        return new ClientDto(
                client.getClientId(),
                client.getClientFirstName(),
                client.getClientLastName(),
                client.getClientEmail(),
                client.getClientPhoneNumber(),
                client.getClientRegistrationDate()
        );
    }

    public List<ClientDto> mapToClientDtoList(final List<Client> clientList) {
        return clientList.stream()
                .map(this::mapToClientDto)
                .collect(Collectors.toList());
    }
}
