package com.carrental.crudRepository;

import com.carrental.domain.Rental;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RentalRepository extends CrudRepository<Rental, Long> {


    @Override
    List<Rental> findAll();

    //Rental findByClientIdAndCarId(long clientId, long carId);
    Optional<Rental> findByClientClientIdAndCarCarId(long clientId, long carId);
}
