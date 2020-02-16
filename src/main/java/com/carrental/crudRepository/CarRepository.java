package com.carrental.crudRepository;

import com.carrental.domain.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    @Override
    List<Car> findAll();

    @Query(value = "select car_id from rentals group by car_id order by count(*) desc limit 1;", nativeQuery = true)
    long mostPopularCarId();
}
