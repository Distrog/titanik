package ru.stroganov.test.titanic.rest.services;

import ru.stroganov.test.titanic.data.entities.PassengerEntity;

import java.util.List;

public interface PassengerService {

    List<PassengerEntity> getAllPassengers(Integer pageNumber, Integer pageSize);

    List<PassengerEntity> getAllPassengersOrderByAscByName(Integer pageNumber, Integer pageSize);

    List<PassengerEntity> getAllPassengersOrderByDescByName(Integer pageNumber, Integer pageSize);

    List<PassengerEntity> getAllPassengersOrderByAscByAge(Integer pageNumber, Integer pageSize);

    List<PassengerEntity> getAllPassengersOrderByDescByAge(Integer pageNumber, Integer pageSize);

    List<PassengerEntity> getAllPassengersOrderByAscByFare(Integer pageNumber, Integer pageSize);

    List<PassengerEntity> getAllPassengersOrderByDescByFare(Integer pageNumber, Integer pageSize);

    List<PassengerEntity> findPassengerByName(String name, Integer pageNumber, Integer pageSize);

    List<PassengerEntity> findPassengersByFilters(Boolean survived, Boolean adult, Boolean male, Boolean withOutRelatives, Integer pageNumber, Integer pageSize);
}
