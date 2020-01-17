package com.carrental.mapper;

import com.carrental.domain.Rental;
import com.carrental.dto.RentalDto;
import com.carrental.service.CarService;
import com.carrental.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentalMapper {

    @Autowired
    private ClientService clientService;

    @Autowired
    private CarService carService;

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private CarMapper carMapper;

    public Rental mapToRental(RentalDto rentalDto) {
        return new Rental(
                rentalDto.getRentalId(),
                clientMapper.mapToClient(rentalDto.getClientDto()),
                carMapper.mapToCar(rentalDto.getCarDto()),
                rentalDto.getBorrowStartDate(),
                rentalDto.getBorrowEndDate(),
                rentalDto.getToPay(),
                rentalDto.getPaidDay()
        );
    }

    public RentalDto mapToRentalDto(Rental rental) {
        return new RentalDto(
                rental.getRentalId(),
                clientMapper.mapToClientDto(rental.getClient()),
                carMapper.mapToCarDto(rental.getCar()),
                rental.getBorrowStartDate(),
                rental.getBorrowEndDate(),
                rental.getToPay(),
                rental.getPaidDay()
        );
    }

    public List<RentalDto> mapToRentalDtoList(List<Rental> rentalList) {
        return rentalList.stream()
                .map(this::mapToRentalDto)
                .collect(Collectors.toList());
    }
}
