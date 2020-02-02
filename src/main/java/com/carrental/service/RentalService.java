package com.carrental.service;

import com.carrental.crudRepository.RentalRepository;
import com.carrental.domain.Rental;
import com.carrental.exception.CarNotReturned;
import com.carrental.exception.NotFoundException;
import com.carrental.exception.RentalAlreadyPaid;
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

    public Rental getRental(long clientId, long carId) throws NotFoundException {
        return rentalRepository.findByClientClientIdAndCarCarId(clientId, carId).orElseThrow(NotFoundException::new);
    }

    public void saveRental(Rental rental) {
        rentalRepository.save(rental);
    }

    public void deleteRental(long rentalId) {
        rentalRepository.deleteById(rentalId);
    }

    public void returnCar(long clientId, long carId){
        Rental rental = rentalRepository.findByClientClientIdAndCarCarId(clientId, carId).orElse(null);
        Date borrowEndDate = new Date();
        rental.setBorrowEndDate(borrowEndDate);
        int rentalHours = (int) (borrowEndDate.getTime() - rental.getBorrowStartDate().getTime()) / 360000;
        double toPay = rental.getCar().getCarModel().getCostPerHour()
                * (1 - rental.getCar().getAmount())
                * rentalHours;
        rental.setToPay(toPay);
        rentalRepository.save(rental);
    }

    public void rentalPaid(long clientId, long carId) throws CarNotReturned, RentalAlreadyPaid {
        Rental rental = rentalRepository.findByClientClientIdAndCarCarId(clientId, carId).orElse(null);
        Date paymentDay = new Date();
        rental.setPaidDay(paymentDay);
        rentalRepository.save(rental);
    }


}
