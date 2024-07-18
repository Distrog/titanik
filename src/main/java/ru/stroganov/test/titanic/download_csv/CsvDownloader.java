package ru.stroganov.test.titanic.download_csv;

import org.springframework.stereotype.Component;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CsvDownloader {

    private final String path = "https://web.stanford.edu/class/archive/cs/cs109/cs109.1166/stuff/titanic.csv";

    public void download() {
        URL url = null;
        try {
            url = new URL(path);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        String fileName = "titanic.csv";
        Path outputPath = Path.of(fileName);

        try(InputStream in = url.openStream()){
            Files.copy(in,outputPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
