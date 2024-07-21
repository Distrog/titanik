package ru.stroganov.test.titanic.rest.controllers;

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
    ResponseEntity<Collection<PassengerDto>> getAllPassengers(@RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                                              @RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {
        List<PassengerEntity> entities = passengerService.getAllPassengers(pageNumber, pageSize);
        List<PassengerDto> dtos = PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(entities);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("order-asc-by-name")
    ResponseEntity<Collection<PassengerDto>> getAllPassengersOrderByAscByName(@RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                                                              @RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {
        List<PassengerEntity> entities = passengerService.getAllPassengersOrderByAscByName(pageNumber, pageSize);
        List<PassengerDto> dtos = PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(entities);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("order-desc-by-name")
    ResponseEntity<Collection<PassengerDto>> getAllPassengersOrderByDescByName(@RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                                                               @RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {
        List<PassengerEntity> entities = passengerService.getAllPassengersOrderByDescByName(pageNumber, pageSize);
        List<PassengerDto> dtos = PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(entities);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("order-asc-by-age")
    ResponseEntity<Collection<PassengerDto>> getAllPassengersOrderByAscByAge(@RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                                                             @RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {
        List<PassengerEntity> entities = passengerService.getAllPassengersOrderByAscByAge(pageNumber, pageSize);
        List<PassengerDto> dtos = PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(entities);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("order-desc-by-age")
    ResponseEntity<Collection<PassengerDto>> getAllPassengersOrderByDescByAge(@RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                                                              @RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {
        List<PassengerEntity> entities = passengerService.getAllPassengersOrderByDescByAge(pageNumber, pageSize);
        List<PassengerDto> dtos = PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(entities);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("order-asc-by-fare")
    ResponseEntity<Collection<PassengerDto>> getAllPassengersOrderByAscByFare(@RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                                                              @RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {
        List<PassengerEntity> entities = passengerService.getAllPassengersOrderByAscByFare(pageNumber, pageSize);
        List<PassengerDto> dtos = PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(entities);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("order-desc-by-fare")
    ResponseEntity<Collection<PassengerDto>> getAllPassengersOrderByDescByFare(@RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                                                               @RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {
        List<PassengerEntity> entities = passengerService.getAllPassengersOrderByDescByFare(pageNumber, pageSize);
        List<PassengerDto> dtos = PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(entities);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(params = {"name"})
    ResponseEntity<Collection<PassengerDto>> findPassengersByName(@RequestParam String name,
                                                                  @RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                                                  @RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {
        List<PassengerEntity> entities = passengerService.findPassengerByName(name, pageNumber, pageSize);
        List<PassengerDto> dtos = PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(entities);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(path = "filters")
    ResponseEntity<Collection<PassengerDto>> findPassengerByFilters(
            @RequestParam(required = false) Boolean survived,
            @RequestParam(required = false) Boolean adult,
            @RequestParam(required = false) Boolean male,
            @RequestParam(name = "with-out-relatives", required = false) Boolean withOutRelatives,
            @RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {
        List<PassengerEntity> entities = passengerService.findPassengersByFilters(survived, adult, male, withOutRelatives, pageNumber, pageSize);
        List<PassengerDto> dtos = PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(entities);
        return ResponseEntity.ok(dtos);
    }
}
