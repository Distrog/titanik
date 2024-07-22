package ru.stroganov.test.titanic.data.repositories;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.stroganov.test.titanic.data.entities.PassengerEntity;

import java.util.List;

//репозиторий наследуемый от jparepositoty (то есть имеет все стандартные crud операции)
public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {

    //метод запрашивает всех пассажиров из базы по имени в требуемом количество (количество записей на странице)
    List<PassengerEntity> findByNameContainsIgnoreCase(String name, PageRequest pageRequest);

    //метод запрашивает всех пассажиров из базы по имени в требуемом количество
    List<PassengerEntity> findByNameContainsIgnoreCase(String name);

    //метод запрашивает всех пассажиров из базы по фильтрам (выжил?, мужчина?, нет родственников на борту?,
    // совершеннолетний?) в требуемом количество (количество записей на странице)
    @Query("SELECT p FROM PassengerEntity p WHERE (:survived is null or p.survived = true) " +
            "and (:adult is null or p.age >= 16) " +
            "and (:male is null or p.sex = true) " +
            "and (:withOutRelatives is null or (p.siblingsAndSpousesAboard = 0 and p.parentsAndChildrenAboard = 0))")
    List<PassengerEntity> findPassengersByFilters
            (@Param("survived") Boolean survived,
             @Param("adult") Boolean adult,
             @Param("male") Boolean male,
             @Param("withOutRelatives") Boolean withOutRelatives, PageRequest pageRequest);

    //метод запрашивает всех пассажиров из базы по фильтрам (выжил?, мужчина?, нет родственников на борту?,
    // совершеннолетний?)
    @Query("SELECT p FROM PassengerEntity p WHERE (:survived is null or p.survived = true) " +
            "and (:adult is null or p.age >= 16) " +
            "and (:male is null or p.sex = true) " +
            "and (:withOutRelatives is null or (p.siblingsAndSpousesAboard = 0 and p.parentsAndChildrenAboard = 0))")
    List<PassengerEntity> findPassengersByFilters
            (@Param("survived") Boolean survived,
             @Param("adult") Boolean adult,
             @Param("male") Boolean male,
             @Param("withOutRelatives") Boolean withOutRelatives);


}
