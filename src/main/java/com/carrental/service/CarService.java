package com.carrental.service;

import com.carrental.crudRepository.CarModelRepository;
import com.carrental.crudRepository.CarRepository;
import com.carrental.crudRepository.CarStatusRepository;
import com.carrental.domain.Car;
import com.carrental.domain.CarModel;
import com.carrental.domain.CarStatus;
import com.carrental.dto.CarDto;
import com.carrental.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarModelRepository carModelRepository;

    @Autowired
    private CarStatusRepository carStatusRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCar(long carId) throws NotFoundException{
        return carRepository.findById(carId).orElseThrow(NotFoundException::new);
    }

    public void addCar(long carModelId, double amount, String reasonOfAmount, int productionYear, String color, long carStatusId) throws NotFoundException {
        CarModel carModel = carModelRepository.findById(carModelId).orElseThrow(NotFoundException::new);
        CarStatus carStatus = carStatusRepository.findById(carStatusId).orElseThrow(NotFoundException::new);
        Car car = new Car(carModel, amount, reasonOfAmount, productionYear, color, carStatus);
        carRepository.save(car);
    }

    public void updateCar(long carId, long carModelId, double amount, String reasonOfAmount, int productionYear, String color, long carStatusId) throws NotFoundException{
        Car car = carRepository.findById(carId).orElseThrow(NotFoundException::new);
        car.setCarModel(carModelRepository.findById(carModelId).orElseThrow(NotFoundException::new));
        car.setAmount(amount);
        car.setReasonOfAmount(reasonOfAmount);
        car.setProductionYear(productionYear);
        car.setColor(color);
        car.setCarStatus(carStatusRepository.findById(carStatusId).orElseThrow(NotFoundException::new));
        carRepository.save(car);
    }

    public void deleteCar(long carId) {
        carRepository.deleteById(carId);
    }

    public Car mostPopularCar() throws NotFoundException{
        long carId = carRepository.mostPopularCarId();
        return carRepository.findById(carId).orElseThrow(NotFoundException::new);
    }
}
