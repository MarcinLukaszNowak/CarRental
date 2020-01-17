package com.carrental.service;

import com.carrental.crudRepository.RentalRepository;
import com.carrental.domain.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental getRental(long rentalId) {
        return rentalRepository.findById(rentalId).orElse(null);
    }

    public void saveRental(Rental rental) {
        rentalRepository.save(rental);
    }

    public void deleteRental(long rentalId) {
        rentalRepository.deleteById(rentalId);
    }

    public void returnCar(long clientId, long carId){
        Rental rental = rentalRepository.findByClientClientIdAndCarCarId(clientId, carId);
        Date borrowEndDate = new Date();
        rental.setBorrowEndDate(borrowEndDate);
        int rentalHours = (int) ( borrowEndDate.getTime() - rental.getBorrowStartDate().getTime()) / 360000;
        double toPay = rental.getCar().getCarModel().getCostPerHour()
                * (1 - rental.getCar().getAmount())
                * rentalHours;
        rental.setToPay(toPay);
        rentalRepository.save(rental);
    }


}
