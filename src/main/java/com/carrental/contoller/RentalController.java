package com.carrental.contoller;

import com.carrental.domain.Rental;
import com.carrental.dto.RentalDto;
import com.carrental.exception.CarNotReturned;
import com.carrental.exception.NotFoundException;
import com.carrental.exception.RentalAlreadyPaid;
import com.carrental.mapper.RentalMapper;
import com.carrental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "rental")
public class RentalController {


    @Autowired
    private RentalService rentalService;

    @Autowired
    private RentalMapper rentalMapper;

    @GetMapping(value = "getAllRentals")
    public List<RentalDto> getAllRentals() {
        return rentalMapper.mapToRentalDtoList(rentalService.getAllRentals());
    }

    @GetMapping(value = "GetRental/{clientId}/{rentalId}")
    public RentalDto getRental(@PathVariable("clientId") long clientId,
                               @PathVariable("rentalId") long carId) throws NotFoundException{
        return rentalMapper.mapToRentalDto(rentalService.getRental(clientId, carId));
    }

    @PostMapping(value = "addRental")
    public void addRental(@RequestParam long clientId,
                          @RequestParam long carId) throws NotFoundException{
        rentalService.addRental(clientId, carId);
    }

    @PutMapping(value = "returnCar")
    public void returnCar(@RequestParam long clientId,
                          @RequestParam long carId){
        rentalService.returnCar(clientId, carId);
    }

    @DeleteMapping(value = "deleteRental/{id}")
    public void deleteRental(@PathVariable("id") long rentalId) {
        rentalService.deleteRental(rentalId);
    }

    @PutMapping(value = "payForRental")
    public void payForRental(@RequestParam long clientId,
                             @RequestParam long carId) throws CarNotReturned, RentalAlreadyPaid, NotFoundException {
        try {
            if(rentalService.getRental(clientId, carId).getRentalEndDate() == null){
                throw new CarNotReturned();
            } else if(rentalService.getRental(clientId, carId).getPaymentDate() != null){
                throw new RentalAlreadyPaid();
            } else {
                rentalService.payForRental(clientId, carId);
            }
        } catch(NotFoundException e) {
            throw e;
        }
    }
}
