package ru.stroganov.test.titanic.rest.dtos;

import ru.stroganov.test.titanic.data.repositories.PassengerRepository;
import ru.stroganov.test.titanic.rest.dtos.PassengerDto;

import java.math.BigDecimal;
import java.util.Collection;

public class PassengerResponse {

    Collection<PassengerDto> passengers;

    BigDecimal sumOfFares;

    Long countOfPassengerHavingRelatives;

    Long countSurvivedPassengers;

    Integer countOfPages;

    public Collection<PassengerDto> getPassengers() {
        return passengers;
    }

    public void setPassengers(Collection<PassengerDto> passengers) {
        this.passengers = passengers;
    }

    public BigDecimal getSumOfFares() {
        return sumOfFares;
    }

    public void setSumOfFares(BigDecimal sumOfFares) {
        this.sumOfFares = sumOfFares;
    }

    public Long getCountOfPassengerHavingRelatives() {
        return countOfPassengerHavingRelatives;
    }

    public void setCountOfPassengerHavingRelatives(Long countOfPassengerHavingRelatives) {
        this.countOfPassengerHavingRelatives = countOfPassengerHavingRelatives;
    }

    public Long getCountSurvivedPassengers() {
        return countSurvivedPassengers;
    }

    public void setCountSurvivedPassengers(Long countSurvivedPassengers) {
        this.countSurvivedPassengers = countSurvivedPassengers;
    }

    public Integer getCountOfPages() {
        return countOfPages;
    }

    public void setCountOfPages(Integer countOfPages) {
        this.countOfPages = countOfPages;
    }
}
