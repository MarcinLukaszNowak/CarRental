package com.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long clientId;

    @Column(name = "clientFirstName")
    private String clientFirstName;

    @Column(name = "clientLastName")
    private String clientLastName;

    @Column(name = "clientEmail")
    private String clientEmail;

    @Column(name = "clientPhoneNumber")
    private String clientPhoneNumber;

    @Column(name = "clientRegistrationDate", updatable = false)
    private Date clientRegistrationDate;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Rental> rentalList = new ArrayList<>();

    public Client(String clientFirstName, String clientLastName, String clientEmail, String clientPhoneNumber, Date clientRegistrationDate) {
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.clientEmail = clientEmail;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientRegistrationDate = clientRegistrationDate;
    }
}
