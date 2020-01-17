package com.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ClientDto {

    private long clientId;
    private String clientFirstName;
    private String clientLastName;
    private String clientEmail;
    private String clientPhoneNumber;
    private String clientRegistrationDate;
}
