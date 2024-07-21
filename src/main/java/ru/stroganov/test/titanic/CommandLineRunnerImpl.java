package ru.stroganov.test.titanic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.stroganov.test.titanic.converter_csv_to_entity.ListOfListsOfStringsToPassengerConverter;
import ru.stroganov.test.titanic.data.repositories.PassengerRepository;

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
        repository.saveAll(converter.convert());
    }
}
