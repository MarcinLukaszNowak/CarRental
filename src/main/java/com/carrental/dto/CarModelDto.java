package com.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CarModelDto {

    private long carModelId;
    private String brand;
    private String modelName;
    private double costPerHour;
}
