package com.carrental.contoller;

import com.carrental.dto.CarModelDto;
import com.carrental.mapper.CarModelMapper;
import com.carrental.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("carModel")
public class CarModelController {

    @Autowired
    private CarModelService carModelService;

    @Autowired
    private CarModelMapper carModelMapper;

    @GetMapping(value = "getAllCarModels")
    public List<CarModelDto> getAllCarModels(){
        return carModelMapper.mapToCarModelDtoList(carModelService.getAllCarModels());
    }

    @GetMapping(value = "getCarModel/{id}")
    public CarModelDto getCarModel(@PathVariable("id") long carModelId){
        return carModelMapper.mapToCarModelDto(carModelService.getCarModel(carModelId));
    }
}
