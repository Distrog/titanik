package ru.stroganov.test.titanic.rest.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.stroganov.test.titanic.data.entities.PassengerEntity;
import ru.stroganov.test.titanic.data.repositories.PassengerRepository;
import ru.stroganov.test.titanic.rest.dtos.PassengerDto;
import ru.stroganov.test.titanic.rest.dtos.PassengerResponse;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository repository;

    public PassengerServiceImpl(PassengerRepository repository) {
        this.repository = repository;
    }

    @Override
    public PassengerResponse getAllPassengers(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        Page<PassengerEntity> page = repository.findAll(pageRequest);
        return getPassengerResponse(page);
    }

    @Override
    public PassengerResponse getAllPassengersOrderByAscByName(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Order.asc("name")));
        Page<PassengerEntity> page = repository.findAll(pageRequest);
        return getPassengerResponse(page);
    }

    @Override
    public PassengerResponse getAllPassengersOrderByDescByName(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Order.desc("name")));
        Page<PassengerEntity> page = repository.findAll(pageRequest);
        return getPassengerResponse(page);
    }

    @Override
    public PassengerResponse getAllPassengersOrderByAscByAge(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Order.asc("age")));
        Page<PassengerEntity> page = repository.findAll(pageRequest);
        return getPassengerResponse(page);
    }

    @Override
    public PassengerResponse getAllPassengersOrderByDescByAge(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Order.desc("age")));
        Page<PassengerEntity> page = repository.findAll(pageRequest);
        return getPassengerResponse(page);
    }

    @Override
    public PassengerResponse getAllPassengersOrderByAscByFare(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Order.asc("fare")));
        Page<PassengerEntity> page = repository.findAll(pageRequest);
        return getPassengerResponse(page);
    }

    @Override
    public PassengerResponse getAllPassengersOrderByDescByFare(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Order.desc("fare")));
        Page<PassengerEntity> page = repository.findAll(pageRequest);
        return getPassengerResponse(page);
    }

    private PassengerResponse getPassengerResponse(Page<PassengerEntity> page) {
        PassengerResponse response = new PassengerResponse();
        response.setCountOfPages(page.getTotalPages());
        List<PassengerEntity> passengers = page.getContent();
        response.setPassengers(PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(passengers));

        setSumOfFares(passengers, response);

        setCountOfSurvivedPassengers(passengers, response);

        setCountOfPassengerHavingRelatives(passengers, response);
        return response;
    }

    private void setCountOfPassengerHavingRelatives(List<PassengerEntity> passengers, PassengerResponse response) {
        Long countOfPassengersWithRelatives = passengers.stream()
                .filter(p -> p.getParentsAndChildrenAboard() > 0 && p.getSiblingsAndSpousesAboard() > 0)
                .count();
        response.setCountOfPassengerHavingRelatives(countOfPassengersWithRelatives);
    }

    private void setCountOfSurvivedPassengers
            (List<PassengerEntity> passengers, PassengerResponse response) {
        Long countOfSurvivedPassenger = passengers.stream()
                .filter(p -> p.getSurvived() == true).count();
        response.setCountSurvivedPassengers(countOfSurvivedPassenger);
    }

    private void setSumOfFares(List<PassengerEntity> passengers, PassengerResponse response) {
        BigDecimal sumOfFares = passengers.stream()
                .map(p -> p.getFare())
                .reduce((f1, f2) -> f1.add(f2)).get();
        response.setSumOfFares(sumOfFares);
    }

    @Override
    public PassengerResponse findPassengerByName(String name, Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        PassengerResponse response = new PassengerResponse();

        List<PassengerEntity> passengers = repository.findByNameContainsIgnoreCase(name, pageRequest);

        response.setPassengers(PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(passengers));

        int countOfPassengers =
                repository.findByNameContainsIgnoreCase(name).size();
        int countOfPages = countOfPassengers / pageSize;
        if (countOfPassengers % pageSize > 0) {
            countOfPages++;
        }
        response.setCountOfPages(countOfPages);

        setSumOfFares(passengers, response);

        setCountOfSurvivedPassengers(passengers, response);

        setCountOfPassengerHavingRelatives(passengers, response);
        return response;
    }

    @Override
    public PassengerResponse findPassengersByFilters(Boolean survived, Boolean adult, Boolean male, Boolean withOutRelatives, Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        PassengerResponse response = new PassengerResponse();

        List<PassengerEntity> passengers = repository.findPassengersByFilters(survived, adult, male, withOutRelatives, pageRequest);

        response.setPassengers(PassengerDto.convertListOfPassengerEntitiesToListOfPassengerDtos(passengers));

        int countOfPassengers =
                repository.findPassengersByFilters(survived, adult, male, withOutRelatives).size();
        int countOfPages = countOfPassengers / pageSize;
        if (countOfPassengers % pageSize > 0) {
            countOfPages++;
        }
        response.setCountOfPages(countOfPages);

        setSumOfFares(passengers, response);

        setCountOfSurvivedPassengers(passengers, response);

        setCountOfPassengerHavingRelatives(passengers, response);
        return response;
    }
}
