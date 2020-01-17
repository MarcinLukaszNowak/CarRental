package com.carrental.service;

import com.carrental.crudRepository.CarStatusRepository;
import com.carrental.domain.CarStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarStatusService {

    @Autowired
    private CarStatusRepository carStatusRepository;

    public List<CarStatus> getAllCarStatuses() {
        return carStatusRepository.findAll();
    }

    public CarStatus getCarStatus(long carStatusId) {
        return carStatusRepository.findById(carStatusId).orElse(null);
    }

    public void saveCarStatus(CarStatus carStatus) {
        carStatusRepository.save(carStatus);
    }

    public void deleteCarStatus(long carStatusId) {
        carStatusRepository.deleteById(carStatusId);
    }
}
