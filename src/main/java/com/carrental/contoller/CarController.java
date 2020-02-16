package com.carrental.contoller;

import com.carrental.dto.CarDto;
import com.carrental.exception.NotFoundException;
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
    public CarDto getCar(@PathVariable("id") long carId) throws NotFoundException {
        return carMapper.mapToCarDto(carService.getCar(carId));
    }

    @PostMapping(value = "addCar")
    public void addCar(@RequestParam long carModelId,
                       @RequestParam double amount,
                       @RequestParam String reasonOfAmount,
                       @RequestParam int productionYear,
                       @RequestParam String color,
                       @RequestParam long carStatusId) throws NotFoundException {
        carService.addCar(carModelId, amount, reasonOfAmount, productionYear, color, carStatusId);
    }

    @PutMapping(value = "updateCar/{id}")
    public void updateCar(@PathVariable("id") long carId,
                          @RequestParam long carModelId,
                          @RequestParam double amount,
                          @RequestParam String reasonOfAmount,
                          @RequestParam int productionYear,
                          @RequestParam String color,
                          @RequestParam long carStatusId) throws NotFoundException {
        carService.updateCar(carId, carModelId, amount, reasonOfAmount, productionYear, color, carStatusId);
    }

    @DeleteMapping(value = "deleteCar/{id}")
    public void deleteCar(@PathVariable("id") long carId) {
        carService.deleteCar(carId);
    }

    @GetMapping(value = "mostPopularCar")
    public CarDto mostPopularCar() throws NotFoundException {
       return carMapper.mapToCarDto(carService.mostPopularCar());
    }
}
