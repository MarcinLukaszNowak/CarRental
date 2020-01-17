package com.carrental.crudRepository;

import com.carrental.domain.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {

    @Override
    List<Client> findAll();
}
