package ru.stroganov.test.titanic.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stroganov.test.titanic.data.entities.PassengerEntity;

import java.util.List;

public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {

}
