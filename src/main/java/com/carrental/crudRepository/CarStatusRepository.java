package com.carrental.crudRepository;

import com.carrental.domain.CarStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarStatusRepository extends CrudRepository<CarStatus, Long> {

    @Override
    List<CarStatus> findAll();
}
