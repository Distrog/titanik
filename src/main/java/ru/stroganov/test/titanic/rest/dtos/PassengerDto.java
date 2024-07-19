package ru.stroganov.test.titanic.rest.dtos;

import jakarta.persistence.*;
import ru.stroganov.test.titanic.data.entities.PassengerEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PassengerDto {
    private Long id;

    private Boolean survived;

    private PassengerEntity.PClass pClass;

    private String name;

    private String sex;

    private Integer age;

    private Integer siblingsAndSpousesAboard;

    private Integer parentsAndChildrenAboard;

    private BigDecimal fare;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSurvived() {
        return survived;
    }

    public void setSurvived(Boolean survived) {
        this.survived = survived;
    }

    public PassengerEntity.PClass getpClass() {
        return pClass;
    }

    public void setpClass(PassengerEntity.PClass pClass) {
        this.pClass = pClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSiblingsAndSpousesAboard() {
        return siblingsAndSpousesAboard;
    }

    public void setSiblingsAndSpousesAboard(Integer siblingsAndSpousesAboard) {
        this.siblingsAndSpousesAboard = siblingsAndSpousesAboard;
    }

    public Integer getParentsAndChildrenAboard() {
        return parentsAndChildrenAboard;
    }

    public void setParentsAndChildrenAboard(Integer parentsAndChildrenAboard) {
        this.parentsAndChildrenAboard = parentsAndChildrenAboard;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public void setFare(BigDecimal fare) {
        this.fare = fare;
    }

    private static PassengerDto convertPassengerEntityToPassengerDto(PassengerEntity entity) {
        PassengerDto dto = new PassengerDto();
        dto.setSurvived(entity.getSurvived());
        dto.setpClass(entity.getpClass());
        dto.setName(entity.getName());
        dto.setSex(entity.getSex() ? "male" : "female");
        dto.setAge((int) Math.floor(entity.getAge()));
        dto.setSiblingsAndSpousesAboard(entity.getSiblingsAndSpousesAboard());
        dto.setParentsAndChildrenAboard(entity.getParentsAndChildrenAboard());
        return dto;
    }

    private static List<PassengerDto> convertListOfPassengerEntitiesToListOfPassengerDtos(List<PassengerEntity> entities) {
        return entities.stream()
                .map(PassengerDto::convertPassengerEntityToPassengerDto)
                .toList();
    }
}
