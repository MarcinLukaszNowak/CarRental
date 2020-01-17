package com.carrental.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Entity(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long rentalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId", updatable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carId", updatable = false)
    private Car car;

    @Column(updatable = false, columnDefinition = "DATETIME")
    private Date borrowStartDate;

    @Column(columnDefinition = "DATETIME")
    private Date borrowEndDate;

    @Column
    private double toPay;

    @Column
    private Date paidDay;

    public void setBorrowEndDate(Date borrowEndDate) {
        this.borrowEndDate = borrowEndDate;
    }

    public void setToPay(double toPay) {
        this.toPay = toPay;
    }

    public void setPaidDay(Date paidDay) {
        this.paidDay = paidDay;
    }

    public Rental(long rentalId, Client client, Car car, Date borrowStartDate, Date borrowEndDate, double toPay, Date paidDay) {
        this.rentalId = rentalId;
        this.client = client;
        this.car = car;
        this.borrowStartDate = new Date();
        this.borrowEndDate = null;
        this.toPay = 0;
        this.paidDay = null;
    }
}
