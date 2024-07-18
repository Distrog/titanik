package ru.stroganov.test.titanic.converter_csv_to_entity;

import org.springframework.stereotype.Component;
import ru.stroganov.test.titanic.entities.PassengerEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class ListOfListsOfStringsToPassengerConverter {
    CsvToListOfListsStringsConverter converter;

    public ListOfListsOfStringsToPassengerConverter(CsvToListOfListsStringsConverter converter) {
        this.converter = converter;
    }

    public Collection<PassengerEntity> convert() {
        List<PassengerEntity> passengerEntities = new ArrayList<>();
        List<List<String>> strings = this.converter.convert();
        strings.remove(0);

        for (List<String> string : strings) {
            List<String> string2 = Arrays.asList(string.get(0).split(","));
            PassengerEntity passengerEntity = new PassengerEntity();
            Boolean survived = false;
            if (string2.get(0).equals("1")) {
                survived = true;
            }
            passengerEntity.setSurvived(survived);

            PassengerEntity.PClass pClass = PassengerEntity.PClass.FIRST;
            if (string2.get(1).equals("2")) {
                pClass = PassengerEntity.PClass.SECOND;
            } else if (string2.get(1).equals("3")) {
                pClass = PassengerEntity.PClass.THIRD;
            }
            passengerEntity.setpClass(pClass);


            passengerEntity.setName(string2.get(2));

            boolean sex = string2.get(3).equals("male");
            passengerEntity.setSex(sex);

            passengerEntity.setAge(Double.valueOf(string2.get(4)));

            passengerEntity.setSiblingsAndSpousesAboard(Integer.valueOf(string2.get(5)));

            passengerEntity.setParentsAndChildrenAboard(Integer.valueOf(string2.get(6)));

            passengerEntity.setFare(BigDecimal.valueOf(Double.parseDouble(string2.get(7))));

            passengerEntities.add(passengerEntity);
        }
        return passengerEntities;
    }

}
