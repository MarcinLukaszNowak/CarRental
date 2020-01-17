package com.carrental.mapper;

import com.carrental.domain.CarModel;
import com.carrental.dto.CarModelDto;
import com.carrental.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarModelMapper {

    public CarModel mapToCarModel(CarModelDto carModelDto) {
        return new CarModel(
                carModelDto.getCarModelId(),
                carModelDto.getBrand(),
                carModelDto.getModelName(),
                carModelDto.getCostPerHour(),
                new ArrayList<>()
        );
    }

    public CarModelDto mapToCarModelDto(CarModel carModel) {
        return new CarModelDto(
                carModel.getCarModelId(),
                carModel.getBrand(),
                carModel.getModelName(),
                carModel.getCostPerHour()
        );
    }

    public List<CarModelDto> mapToCarModelDtoList(List<CarModel> carModelList) {
        return carModelList.stream()
                .map(this::mapToCarModelDto)
                .collect(Collectors.toList());
    }
}
