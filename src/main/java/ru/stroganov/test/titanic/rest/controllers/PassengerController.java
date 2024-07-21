package ru.stroganov.test.titanic.rest.controllers;

import org.hibernate.type.descriptor.sql.internal.NativeEnumDdlTypeImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.stroganov.test.titanic.data.entities.PassengerEntity;
import ru.stroganov.test.titanic.rest.dtos.PassengerDto;
import ru.stroganov.test.titanic.rest.services.PassengerService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("passengers")
public class PassengerController {
    PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    ResponseEntity<Collection<PassengerDto>> getAllPassengers() {
        List<PassengerEntity> entities = passengerService.getAllPassengers();
        List<PassengerDto> dtos = PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(entities);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("order-asc-by-name")
    ResponseEntity<Collection<PassengerDto>> getAllPassengersOrderByAscByName() {
        List<PassengerEntity> entities = passengerService.getAllPassengersOrderByAscByName();
        List<PassengerDto> dtos = PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(entities);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("order-desc-by-name")
    ResponseEntity<Collection<PassengerDto>> getAllPassengersOrderByDescByName() {
        List<PassengerEntity> entities = passengerService.getAllPassengersOrderByDescByName();
        List<PassengerDto> dtos = PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(entities);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("order-asc-by-age")
    ResponseEntity<Collection<PassengerDto>> getAllPassengersOrderByAscByAge() {
        List<PassengerEntity> entities = passengerService.getAllPassengersOrderByAscByAge();
        List<PassengerDto> dtos = PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(entities);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("order-desc-by-age")
    ResponseEntity<Collection<PassengerDto>> getAllPassengersOrderByDescByAge() {
        List<PassengerEntity> entities = passengerService.getAllPassengersOrderByDescByAge();
        List<PassengerDto> dtos = PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(entities);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("order-asc-by-fare")
    ResponseEntity<Collection<PassengerDto>> getAllPassengersOrderByAscByFare() {
        List<PassengerEntity> entities = passengerService.getAllPassengersOrderByAscByFare();
        List<PassengerDto> dtos = PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(entities);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("order-desc-by-fare")
    ResponseEntity<Collection<PassengerDto>> getAllPassengersOrderByDescByFare() {
        List<PassengerEntity> entities = passengerService.getAllPassengersOrderByDescByFare();
        List<PassengerDto> dtos = PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(entities);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(params = {"name"})
    ResponseEntity<Collection<PassengerDto>> findPassengersByName(@RequestParam String name) {
        List<PassengerEntity> entities = passengerService.findPassengerByName(name);
        List<PassengerDto> dtos = PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(entities);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(path = "filters")
    ResponseEntity<Collection<PassengerDto>> findPassengerByFilters(
            @RequestParam(required = false) Boolean survived,
            @RequestParam(required = false) Boolean adult,
            @RequestParam(required = false) Boolean male,
            @RequestParam(name = "with-out-relatives", required = false) Boolean withOutRelatives) {
        List<PassengerEntity> entities = passengerService.findPassengersByFilters(survived, adult, male, withOutRelatives);
        List<PassengerDto> dtos = PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(entities);
        return ResponseEntity.ok(dtos);
    }
}
