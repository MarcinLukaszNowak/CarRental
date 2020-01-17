package com.carrental.contoller;

import com.carrental.dto.CarDto;
import com.carrental.mapper.CarMapper;
import com.carrental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "car")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarMapper carMapper;

    @GetMapping(value = "getAllCars")
    public List<CarDto> getAllCars() {
        return carMapper.mapToCarDtoList(carService.getAllCars());
    }

    @GetMapping(value = "getCar/{id}")
    public CarDto getCar(@PathVariable("id") long carId) {
        return carMapper.mapToCarDto(carService.getCar(carId));
    }

    @PostMapping(value = "addCar")
    public void addCar(@RequestBody CarDto carDto) {
        carService.saveCar(carMapper.mapToCar(carDto));
    }

    @PutMapping(value = "updateCar")
    public void updateCar(@RequestBody CarDto carDto) {
        carService.saveCar(carMapper.mapToCar(carDto));
    }

    @DeleteMapping(value = "deleteCar/{id}")
    public void deleteCar(@PathVariable("id") long carId) {
        carService.deleteCar(carId);
    }

}
