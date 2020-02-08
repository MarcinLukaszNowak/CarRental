package com.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long rentalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId", updatable = false, referencedColumnName = "clientId")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carId", updatable = false, referencedColumnName = "carId")
    private Car car;

    @Column(updatable = false, columnDefinition = "DATETIME")
    private Date rentalStartDate;

    @Column(columnDefinition = "DATETIME")
    private Date rentalEndDate;

    @Column
    private double toPay;

    @Column
    private Date paymentDate;

    public void setRentalEndDate(Date rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    public void setToPay(double toPay) {
        this.toPay = toPay;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Rental(Client client, Car car) {
        this.client = client;
        this.car = car;
        this.rentalStartDate = new Date();
    }
}
