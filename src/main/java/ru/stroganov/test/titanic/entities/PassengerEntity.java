package ru.stroganov.test.titanic.entities;

import java.math.BigDecimal;

public class PassengerEntity {
    public enum PClass{
        FIRST,
        SECOND,
        THIRD
    }
    private Long id;

    private Boolean survived;

    private PClass pClass;

    private String name;

    private Boolean sex;

    private Double age;

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

    public PClass getpClass() {
        return pClass;
    }

    public void setpClass(PClass pClass) {
        this.pClass = pClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
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
}
