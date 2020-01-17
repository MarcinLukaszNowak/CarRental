package com.carrental.mapper;

import com.carrental.domain.Car;
import com.carrental.domain.CarModel;
import com.carrental.domain.CarStatus;
import com.carrental.domain.Rental;
import com.carrental.dto.CarDto;
import com.carrental.dto.CarStatusDto;
import com.carrental.service.CarModelService;
import com.carrental.service.CarService;
import com.carrental.service.CarStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarMapper {

    @Autowired
    private CarModelMapper carModelMapper;

    @Autowired
    private CarStatusMapper carStatusMapper;

    public Car mapToCar(final CarDto carDto) {
        return new Car(
                carDto.getCarId(),
                carModelMapper.mapToCarModel(carDto.getCarModelDto()),
                carDto.getAmount(),
                carDto.getReasonOfAmount(),
                carDto.getProductionYear(),
                carDto.getColor(),
                carStatusMapper.mapToCarStatus((carDto.getCarStatusDto())),
                new ArrayList<>()
        );
    }

    public CarDto mapToCarDto(final Car car) {
        return new CarDto(
                car.getCarId(),
                carModelMapper.mapToCarModelDto(car.getCarModel()),
                car.getAmount(),
                car.getReasonOfAmount(),
                car.getProductionYear(),
                car.getColor(),
                carStatusMapper.mapToCarStatusDto(car.getCarStatus())
        );
    }

    public List<CarDto> mapToCarDtoList(List<Car> carList) {
        return carList.stream()
                .map(this::mapToCarDto)
                .collect(Collectors.toList());
    }

}
