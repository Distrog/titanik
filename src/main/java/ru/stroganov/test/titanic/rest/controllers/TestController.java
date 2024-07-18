package ru.stroganov.test.titanic.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stroganov.test.titanic.download_csv.CsvDownloader;

import java.util.List;

@RestController
public class TestController {

    CsvDownloader downloader;

    public TestController(CsvDownloader downloader) {
        this.downloader = downloader;
    }

    @GetMapping
    public void test(){
        downloader.download();
    }
}
