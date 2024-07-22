package ru.stroganov.test.titanic.rest.services;

import org.springframework.cache.annotation.Cacheable;
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

    //возвращает всех пассажиров
    @Override
    @Cacheable("allPassengers")
    public PassengerResponse getAllPassengers(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        Page<PassengerEntity> page = repository.findAll(pageRequest);
        return getPassengerResponse(page);
    }

    //возвращает всех пассажиров, отсортированных по имени в прямом порядке
    @Override
    @Cacheable("allPassengersOrderByAscByName")
    public PassengerResponse getAllPassengersOrderByAscByName(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Order.asc("name")));
        Page<PassengerEntity> page = repository.findAll(pageRequest);
        return getPassengerResponse(page);
    }

    //возвращает всех пассажиров, отсортированных по имени в обратном порядке
    @Override
    @Cacheable("allPassengersOrderByDescByName")
    public PassengerResponse getAllPassengersOrderByDescByName(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Order.desc("name")));
        Page<PassengerEntity> page = repository.findAll(pageRequest);
        return getPassengerResponse(page);
    }

    //возвращает всех пассажиров, отсортированных по возрасту в прямом порядке
@Cacheable("allPassengersOrderByAscByAge")
    @Override
    public PassengerResponse getAllPassengersOrderByAscByAge(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Order.asc("age")));
        Page<PassengerEntity> page = repository.findAll(pageRequest);
        return getPassengerResponse(page);
    }

    //возвращает всех пассажиров, отсортированных по возрасту в обратном порядке
    @Cacheable("allPassengersOrderByDescByAge")
    @Override
    public PassengerResponse getAllPassengersOrderByDescByAge(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Order.desc("age")));
        Page<PassengerEntity> page = repository.findAll(pageRequest);
        return getPassengerResponse(page);
    }

    //возвращает всех пассажиров, отсортированных по стоимости проезда в прямом порядке
    @Cacheable("allPassengersOrderByAscByFare")
    @Override
    public PassengerResponse getAllPassengersOrderByAscByFare(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Order.asc("fare")));
        Page<PassengerEntity> page = repository.findAll(pageRequest);
        return getPassengerResponse(page);
    }

    //возвращает всех пассажиров, отсортированных по стоимости проезда в обратном порядке
    @Override
    @Cacheable("allPassengersOrderByDescByFare")
    public PassengerResponse getAllPassengersOrderByDescByFare(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Order.desc("fare")));
        Page<PassengerEntity> page = repository.findAll(pageRequest);
        return getPassengerResponse(page);
    }


    //вспомогательный метод собирающий passengerResponse для методов возвращающих всех пассажиров
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

    //вспомогательный метод вычисляющий пассажиров у которых были родственники на борту
    private void setCountOfPassengerHavingRelatives(List<PassengerEntity> passengers, PassengerResponse response) {
        Long countOfPassengersWithRelatives = passengers.stream()
                .filter(p -> p.getParentsAndChildrenAboard() > 0 && p.getSiblingsAndSpousesAboard() > 0)
                .count();
        response.setCountOfPassengerHavingRelatives(countOfPassengersWithRelatives);
    }

    //вспомогательный метод вычисляющий выживших пассажиров
    private void setCountOfSurvivedPassengers
            (List<PassengerEntity> passengers, PassengerResponse response) {
        Long countOfSurvivedPassenger = passengers.stream()
                .filter(p -> p.getSurvived() == true).count();
        response.setCountSurvivedPassengers(countOfSurvivedPassenger);
    }

    //вспомогательный метод вычисляющий сумму стоимости билетов
    private void setSumOfFares(List<PassengerEntity> passengers, PassengerResponse response) {
        BigDecimal sumOfFares = passengers.stream()
                .map(p -> p.getFare())
                .reduce((f1, f2) -> f1.add(f2)).get();
        response.setSumOfFares(sumOfFares);
    }

    //возвращает всех пассажиров имя которых содержит символы
    @Override
    @Cacheable("passengersWithName")
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

    //возвращает всех пассажиров после фильтраций
    @Override
    @Cacheable("passengersWithFilters")
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
