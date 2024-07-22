package ru.stroganov.test.titanic.rest.controllers;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.stroganov.test.titanic.rest.dtos.PassengerResponse;
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
    ResponseEntity<PassengerResponse> getAllPassengers(@RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                                       @RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {

        return ResponseEntity.ok(passengerService.getAllPassengers(pageNumber, pageSize));
    }

    @GetMapping("order-asc-by-name")
    ResponseEntity<PassengerResponse> getAllPassengersOrderByAscByName(@RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                                                       @RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {
        return ResponseEntity.ok(passengerService.getAllPassengersOrderByAscByName(pageNumber, pageSize));
    }

    @GetMapping("order-desc-by-name")
    ResponseEntity<PassengerResponse> getAllPassengersOrderByDescByName(@RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                                                        @RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {
        return ResponseEntity.ok(passengerService.getAllPassengersOrderByDescByName(pageNumber, pageSize));
    }

    @GetMapping("order-asc-by-age")
    ResponseEntity<PassengerResponse> getAllPassengersOrderByAscByAge(@RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                                                      @RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {
        return ResponseEntity.ok(passengerService.getAllPassengersOrderByAscByAge(pageNumber, pageSize));
    }

    @GetMapping("order-desc-by-age")
    ResponseEntity<PassengerResponse> getAllPassengersOrderByDescByAge(@RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                                                       @RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {
        return ResponseEntity.ok(passengerService.getAllPassengersOrderByDescByAge(pageNumber, pageSize));
    }

    @GetMapping("order-asc-by-fare")
    ResponseEntity<PassengerResponse> getAllPassengersOrderByAscByFare(@RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                                                       @RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {
        return ResponseEntity.ok(passengerService.getAllPassengersOrderByAscByFare(pageNumber, pageSize));
    }

    @GetMapping("order-desc-by-fare")
    ResponseEntity<PassengerResponse> getAllPassengersOrderByDescByFare(@RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                                                        @RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {

        return ResponseEntity.ok(passengerService.getAllPassengersOrderByDescByFare(pageNumber, pageSize));
    }

    @GetMapping(params = {"name"})
    ResponseEntity<PassengerResponse> findPassengersByName(@RequestParam String name,
                                                           @RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                                           @RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {

        return ResponseEntity.ok(passengerService.findPassengerByName(name, pageNumber, pageSize));
    }

    @GetMapping(path = "filters")
    ResponseEntity<PassengerResponse> findPassengerByFilters(
            @RequestParam(required = false) Boolean survived,
            @RequestParam(required = false) Boolean adult,
            @RequestParam(required = false) Boolean male,
            @RequestParam(name = "with-out-relatives", required = false) Boolean withOutRelatives,
            @RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {
;
        return ResponseEntity.ok(passengerService
                .findPassengersByFilters(survived,adult,male,withOutRelatives,pageNumber,pageSize));
    }
}
