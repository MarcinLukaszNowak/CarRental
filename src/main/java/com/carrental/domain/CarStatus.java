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
@Entity(name = "carStatuses")
public class CarStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int carStatusId;

    @Column
    private String carStatusDescription;

    @OneToMany(mappedBy = "carStatus", fetch = FetchType.LAZY)
    private List<Car> carList = new ArrayList<>();
}
