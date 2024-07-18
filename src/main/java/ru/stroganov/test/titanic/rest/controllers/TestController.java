package ru.stroganov.test.titanic.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stroganov.test.titanic.converter_csv_to_entity.CsvToListOfListsStringsConverter;
import ru.stroganov.test.titanic.download_csv.CsvDownloader;

import java.util.List;

@RestController
public class TestController {

    CsvDownloader downloader;
    CsvToListOfListsStringsConverter converter;

    public TestController(CsvDownloader downloader, CsvToListOfListsStringsConverter converter) {
        this.downloader = downloader;
        this.converter = converter;
    }

    @GetMapping
    public List<List<String>> test(){
        downloader.download();
        return converter.convert();
    }
}
