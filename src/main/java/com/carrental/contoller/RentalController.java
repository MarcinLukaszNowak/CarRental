package com.carrental.contoller;

import com.carrental.dto.RentalDto;
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
}
