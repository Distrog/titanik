package ru.stroganov.test.titanic.rest.services;

import ru.stroganov.test.titanic.rest.dtos.PassengerResponse;

public interface PassengerService {

    PassengerResponse getAllPassengers(Integer pageNumber, Integer pageSize);

    PassengerResponse getAllPassengersOrderByAscByName(Integer pageNumber, Integer pageSize);

    PassengerResponse getAllPassengersOrderByDescByName(Integer pageNumber, Integer pageSize);

    PassengerResponse getAllPassengersOrderByAscByAge(Integer pageNumber, Integer pageSize);

    PassengerResponse getAllPassengersOrderByDescByAge(Integer pageNumber, Integer pageSize);

    PassengerResponse getAllPassengersOrderByAscByFare(Integer pageNumber, Integer pageSize);

    PassengerResponse getAllPassengersOrderByDescByFare(Integer pageNumber, Integer pageSize);

    PassengerResponse findPassengerByName(String name, Integer pageNumber, Integer pageSize);

   PassengerResponse findPassengersByFilters(Boolean survived, Boolean adult, Boolean male, Boolean withOutRelatives, Integer pageNumber, Integer pageSize);
}
