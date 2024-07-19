package ru.stroganov.test.titanic.rest.services;

import org.springframework.http.ResponseEntity;
import ru.stroganov.test.titanic.rest.dtos.PassengerDto;

import java.util.Collection;

public interface PassengerService {

    void getAllPassengers();
}
