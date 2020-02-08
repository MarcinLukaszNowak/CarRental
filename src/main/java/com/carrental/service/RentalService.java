package com.carrental.service;

import com.carrental.crudRepository.CarRepository;
import com.carrental.crudRepository.ClientRepository;
import com.carrental.crudRepository.RentalRepository;
import com.carrental.domain.Car;
import com.carrental.domain.Client;
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

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CarRepository carRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental getRental(long clientId, long carId) throws NotFoundException {
        return rentalRepository.findByClientClientIdAndCarCarId(clientId, carId).orElseThrow(NotFoundException::new);
    }

    public void saveRental(long clientId, long carId) throws NotFoundException{
        Client client = clientRepository.findById(clientId).orElseThrow(NotFoundException::new);
        Car car = carRepository.findById(carId).orElseThrow(NotFoundException::new);
        Rental rental = new Rental(client, car);
        rentalRepository.save(rental);
    }

    public void deleteRental(long rentalId) {
        rentalRepository.deleteById(rentalId);
    }

    public void returnCar(long clientId, long carId){
        Rental rental = rentalRepository.findByClientClientIdAndCarCarId(clientId, carId).orElse(null);
        Date rentalEndDate = new Date();
        rental.setRentalEndDate(rentalEndDate);
        int rentalHours = (int) (rentalEndDate.getTime() - rental.getRentalStartDate().getTime()) / 360000;
        double toPay = rental.getCar().getCarModel().getCostPerHour()
                * (1 - rental.getCar().getAmount())
                * rentalHours;
        rental.setToPay(toPay);
        rentalRepository.save(rental);
    }

    public void payForRental(long clientId, long carId) throws CarNotReturned, RentalAlreadyPaid {
        Rental rental = rentalRepository.findByClientClientIdAndCarCarId(clientId, carId).orElse(null);
        Date paymentDate = new Date();
        rental.setPaymentDate(paymentDate);
        rentalRepository.save(rental);
    }


}
