package ru.stroganov.test.titanic.rest.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.stroganov.test.titanic.data.entities.PassengerEntity;
import ru.stroganov.test.titanic.data.repositories.PassengerRepository;

import java.util.List;
@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository repository;

    public PassengerServiceImpl(PassengerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PassengerEntity> getAllPassengers() {
        return repository.findAll();
    }

    @Override
    public List<PassengerEntity> getAllPassengersOrderByAscByName() {
        return repository.findAll(Sort.by(Sort.Order.asc("name")));
    }

    @Override
    public List<PassengerEntity> getAllPassengersOrderByDescByName() {
        return repository.findAll(Sort.by(Sort.Order.desc("name")));
    }

    @Override
    public List<PassengerEntity> getAllPassengersOrderByAscByAge() {
        return repository.findAll(Sort.by(Sort.Order.asc("age")));
    }

    @Override
    public List<PassengerEntity> getAllPassengersOrderByDescByAge() {
        return repository.findAll(Sort.by(Sort.Order.desc("name")));
    }

    @Override
    public List<PassengerEntity> getAllPassengersOrderByAscByFare() {
        return repository.findAll(Sort.by(Sort.Order.asc("fare")));
    }

    @Override
    public List<PassengerEntity> getAllPassengersOrderByDescByFare() {
        return repository.findAll(Sort.by(Sort.Order.desc("fare")));
    }

    @Override
    public List<PassengerEntity> findPassengerByName(String name) {
        return repository.findByNameContainsIgnoreCase(name);
    }

    @Override
    public List<PassengerEntity> findPassengersByFilters(Boolean survived, Boolean adult, Boolean male, Boolean withOutRelatives) {
        return repository.findPassengersByFilters(survived, adult, male, withOutRelatives);
    }
}
