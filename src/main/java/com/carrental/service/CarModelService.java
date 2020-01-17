package com.carrental.service;

import com.carrental.crudRepository.CarModelRepository;
import com.carrental.domain.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarModelService {

    @Autowired
    private CarModelRepository carModelRepository;

    public List<CarModel> getAllCarModels() {
        return carModelRepository.findAll();
    }

    public CarModel getCarModel(long carModelId) {
        return carModelRepository.findById(carModelId).orElse(null);
    }
}
