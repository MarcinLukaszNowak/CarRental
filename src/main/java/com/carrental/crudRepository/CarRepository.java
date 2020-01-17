package com.carrental.crudRepository;

import com.carrental.domain.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    @Override
    List<Car> findAll();
}
