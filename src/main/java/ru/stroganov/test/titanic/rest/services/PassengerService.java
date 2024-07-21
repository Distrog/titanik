package ru.stroganov.test.titanic.rest.services;

import ru.stroganov.test.titanic.data.entities.PassengerEntity;

import java.util.List;

public interface PassengerService {

    List<PassengerEntity> getAllPassengers();

    List<PassengerEntity> getAllPassengersOrderByAscByName();

    List<PassengerEntity> getAllPassengersOrderByDescByName();

    List<PassengerEntity> getAllPassengersOrderByAscByAge();

    List<PassengerEntity> getAllPassengersOrderByDescByAge();

    List<PassengerEntity> getAllPassengersOrderByAscByFare();

    List<PassengerEntity> getAllPassengersOrderByDescByFare();

    List<PassengerEntity> findPassengerByName(String name);

    List<PassengerEntity> findPassengersByFilters(Boolean survived, Boolean adult, Boolean male, Boolean withOutRelatives);
}
