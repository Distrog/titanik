package ru.stroganov.test.titanic.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stroganov.test.titanic.converter_csv_to_entity.ListOfListsOfStringsToPassengerConverter;
import ru.stroganov.test.titanic.data.entities.PassengerEntity;

import java.util.Collection;

@RestController
public class InitController {

   private final ListOfListsOfStringsToPassengerConverter converter;

    public InitController(ListOfListsOfStringsToPassengerConverter converter) {
        this.converter = converter;
    }

    @GetMapping
    public Collection<PassengerEntity> test(){
      return converter.convert();
    }
}
