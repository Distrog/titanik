package ru.stroganov.test.titanic.rest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stroganov.test.titanic.data.entities.PassengerEntity;
import ru.stroganov.test.titanic.rest.dtos.PassengerDto;
import ru.stroganov.test.titanic.rest.services.PassengerService;

import java.util.Collection;

@RestController
@RequestMapping("passengers")
public class PassengerController {
    PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    ResponseEntity<Collection<PassengerDto>> getAllPassengers(){
        passengerService.getAllPassengers();
    }
}
