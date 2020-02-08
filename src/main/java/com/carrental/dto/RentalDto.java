package com.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class RentalDto {
    private long rentalId;
    private ClientDto clientDto;
    private CarDto carDto;
    private Date rentalStartDate;
    private Date rentalEndDate;
    private double toPay;
    private Date paymentDate;
}
