package com.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long carId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modelId")
    private CarModel carModel;

    @Column
    private double amount;

    @Column
    private String reasonOfAmount;

    @Column
    private int productionYear;

    @Column
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carStatusId")
    private CarStatus carStatus;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private List<Rental> rentalList = new ArrayList<>();

    public Car(CarModel carModel, double amount, String reasonOfAmount, int productionYear, String color, CarStatus carStatus) {
        this.carModel = carModel;
        this.amount = amount;
        this.reasonOfAmount = reasonOfAmount;
        this.productionYear = productionYear;
        this.color = color;
        this.carStatus = carStatus;
    }
}
