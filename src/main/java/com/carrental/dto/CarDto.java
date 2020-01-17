package com.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CarDto {

    private long carId;
    private CarModelDto carModelDto;
    private double amount;
    private String reasonOfAmount;
    private String productionYear;
    private String color;
    private CarStatusDto carStatusDto;
}
