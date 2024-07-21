package ru.stroganov.test.titanic.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stroganov.test.titanic.converter_csv_to_entity.ListOfListsOfStringsToPassengerConverter;
import ru.stroganov.test.titanic.data.entities.PassengerEntity;
import ru.stroganov.test.titanic.data.repositories.PassengerRepository;

import java.util.Collection;

@RestController
public class InitController {

    private final ListOfListsOfStringsToPassengerConverter converter;
    private final PassengerRepository repository;

    public InitController(ListOfListsOfStringsToPassengerConverter converter, PassengerRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    @GetMapping
    public Collection<PassengerEntity> test() {
        repository.saveAll(converter.convert());
        return converter.convert();
    }
}
