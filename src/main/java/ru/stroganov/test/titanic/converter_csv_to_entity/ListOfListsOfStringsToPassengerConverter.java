package ru.stroganov.test.titanic.converter_csv_to_entity;

import org.springframework.stereotype.Component;
import ru.stroganov.test.titanic.data.entities.PassengerEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

// класс преобразует лист строк в коллекцию пассажиров
//преобразует поле выжившие из численного в булеан
//преобразует пол в булеан (муж - true, жен - false)
//преобзует класс (численное поле) в enum
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

            passengerEntity.setSurvived(convertStringToSurvived(string2.get(0)));

            passengerEntity.setpClass(convertStringToPClass(string2.get(1)));

            passengerEntity.setName(string2.get(2));

            passengerEntity.setSex(convertStringToSex(string2.get(3)));

            passengerEntity.setAge(Double.valueOf(string2.get(4)));

            passengerEntity.setSiblingsAndSpousesAboard(Integer.valueOf(string2.get(5)));

            passengerEntity.setParentsAndChildrenAboard(Integer.valueOf(string2.get(6)));

            passengerEntity.setFare(BigDecimal.valueOf(Double.parseDouble(string2.get(7))));

            passengerEntities.add(passengerEntity);
        }
        return passengerEntities;
    }

    Boolean convertStringToSurvived(String s) {
        boolean survived = s.equals("1");
        return survived;
    }

    PassengerEntity.PClass convertStringToPClass(String s) {
        PassengerEntity.PClass pClass = PassengerEntity.PClass.FIRST;
        if (s.equals("2")) {
            pClass = PassengerEntity.PClass.SECOND;
        } else if (s.equals("3")) {
            pClass = PassengerEntity.PClass.THIRD;
        }
        return pClass;
    }

    Boolean convertStringToSex(String s) {
        return s.equals("male");
    }

}
