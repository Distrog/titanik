package ru.stroganov.test.titanic.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stroganov.test.titanic.converter_csv_to_entity.CsvToListOfListsStringsConverter;
import ru.stroganov.test.titanic.converter_csv_to_entity.ListOfListsOfStringsToPassengerConverter;
import ru.stroganov.test.titanic.download_csv.CsvDownloader;
import ru.stroganov.test.titanic.entities.PassengerEntity;

import java.util.Collection;
import java.util.List;

@RestController
public class TestController {

   private final ListOfListsOfStringsToPassengerConverter converter;

    public TestController(ListOfListsOfStringsToPassengerConverter converter) {
        this.converter = converter;
    }

    @GetMapping
    public Collection<PassengerEntity> test(){
      return converter.convert();
    }
}
