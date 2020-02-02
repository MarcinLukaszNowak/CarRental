package com.carrental.service;

import com.carrental.crudRepository.CarRepository;
import com.carrental.domain.Car;
import com.carrental.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCar(long carId) throws NotFoundException{
        return carRepository.findById(carId).orElseThrow(NotFoundException::new);
    }

    public void saveCar(Car car) {
        carRepository.save(car);
    }

    public void deleteCar(long carId) {
        carRepository.deleteById(carId);
    }
}
