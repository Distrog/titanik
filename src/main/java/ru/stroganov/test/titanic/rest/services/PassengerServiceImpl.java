package ru.stroganov.test.titanic.rest.services;

import org.springframework.data.domain.PageRequest;
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
    public List<PassengerEntity> getAllPassengers(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber-1,pageSize);
        return repository.findAll(pageRequest).getContent();
    }

    @Override
    public List<PassengerEntity> getAllPassengersOrderByAscByName(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber-1,pageSize,Sort.by(Sort.Order.asc("name")));
        return repository.findAll(pageRequest).getContent();
    }

    @Override
    public List<PassengerEntity> getAllPassengersOrderByDescByName(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber-1,pageSize,Sort.by(Sort.Order.desc("name")));
        return repository.findAll(pageRequest).getContent();
    }

    @Override
    public List<PassengerEntity> getAllPassengersOrderByAscByAge(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber-1,pageSize,Sort.by(Sort.Order.asc("age")));
        return repository.findAll(pageRequest).getContent();
    }

    @Override
    public List<PassengerEntity> getAllPassengersOrderByDescByAge(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber-1,pageSize,Sort.by(Sort.Order.desc("age")));
        return repository.findAll(pageRequest).getContent();
    }

    @Override
    public List<PassengerEntity> getAllPassengersOrderByAscByFare(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber-1,pageSize,Sort.by(Sort.Order.asc("fare")));
        return repository.findAll(pageRequest).getContent();
    }

    @Override
    public List<PassengerEntity> getAllPassengersOrderByDescByFare(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber-1,pageSize,Sort.by(Sort.Order.desc("fare")));
        return repository.findAll(pageRequest).getContent();
    }

    @Override
    public List<PassengerEntity> findPassengerByName(String name, Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber-1,pageSize);
        return repository.findByNameContainsIgnoreCase(name,pageRequest);
    }

    @Override
    public List<PassengerEntity> findPassengersByFilters(Boolean survived, Boolean adult, Boolean male, Boolean withOutRelatives, Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber-1,pageSize);
        return repository.findPassengersByFilters(survived, adult, male, withOutRelatives,pageRequest);
    }
}
