package ru.stroganov.test.titanic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.stroganov.test.titanic.converter_csv_to_entity.ListOfListsOfStringsToPassengerConverter;
import ru.stroganov.test.titanic.data.repositories.PassengerRepository;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final ListOfListsOfStringsToPassengerConverter converter;
    private final PassengerRepository repository;

    public CommandLineRunnerImpl(ListOfListsOfStringsToPassengerConverter converter, PassengerRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        Path path = Paths.get("titanic.csv");
        if (Files.notExists(path) && repository.findAll().size() == 0) {
            repository.saveAll(converter.convert());
        }
    }
}
