package com.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "carModels")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long carModelId;

    @Column
    private String brand;

    @Column
    private String modelName;

    @Column
    private double costPerHour;

    @OneToMany(mappedBy = "carModel", fetch = FetchType.LAZY)
    private List<Car> carList = new ArrayList<>();


}
