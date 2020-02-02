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
    public RentalDto getRental(@PathVariable("clientId") long clientId, @PathVariable("rentalId") long carId) throws NotFoundException{
        return rentalMapper.mapToRentalDto(rentalService.getRental(clientId, carId));
    }

    @PostMapping(value = "addRental")
    public void addRental(@RequestBody RentalDto rentalDto) {
        rentalService.saveRental(rentalMapper.mapToRental(rentalDto));
    }

    @PutMapping(value = "updateRental")
    public void updateRental(@RequestBody RentalDto rentalDto) {
        rentalService.saveRental(rentalMapper.mapToRental(rentalDto));
    }

    @PutMapping(value = "returnCar")
    public void returnCar(@RequestParam long clientId, @RequestParam long carId){
        rentalService.returnCar(clientId, carId);
    }

    @DeleteMapping(value = "deleteRental/{id}")
    public void deleteRental(@PathVariable("id") long rentalId) {
        rentalService.deleteRental(rentalId);
    }

    @PutMapping(value = "rentalPaid")
    public void rentalPaid(@RequestParam long clientId, @RequestParam long carId) throws CarNotReturned, RentalAlreadyPaid, NotFoundException {
        try {
            if(rentalService.getRental(clientId, carId).getBorrowEndDate() == null){
                throw new CarNotReturned();
            } else if(rentalService.getRental(clientId, carId).getPaidDay() != null){
                throw new RentalAlreadyPaid();
            } else {
                rentalService.rentalPaid(clientId, carId);
            }
        } catch (NotFoundException e) {
            throw e;
        }
    }
}
