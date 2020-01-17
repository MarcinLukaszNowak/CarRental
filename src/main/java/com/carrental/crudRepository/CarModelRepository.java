package com.carrental.crudRepository;

import com.carrental.domain.CarModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarModelRepository extends CrudRepository<CarModel, Long> {

    @Override
    List<CarModel> findAll();
}
