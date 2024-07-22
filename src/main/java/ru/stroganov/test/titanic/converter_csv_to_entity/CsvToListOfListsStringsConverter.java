package ru.stroganov.test.titanic.converter_csv_to_entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.stroganov.test.titanic.download_csv.CsvDownloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CsvToListOfListsStringsConverter {

    private final CsvDownloader downloader;

    public CsvToListOfListsStringsConverter(CsvDownloader downloader) {
        this.downloader = downloader;
    }

    @Value("${csv.path}")
    private String path ;

    public List<List<String>> convert() {
        downloader.download();
        List<List<String>> passengersString = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\n");
                passengersString.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return passengersString;
    }
}
