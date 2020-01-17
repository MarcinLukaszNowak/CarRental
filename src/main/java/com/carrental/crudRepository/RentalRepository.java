package com.carrental.crudRepository;

import com.carrental.domain.Rental;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentalRepository extends CrudRepository<Rental, Long> {


    @Override
    List<Rental> findAll();

    //Rental findByClientIdAndCarId(long clientId, long carId);
    Rental findByClientClientIdAndCarCarId(long clientId, long carId);
}
