package ru.stroganov.test.titanic.entities;

public class PassengerEntity {
    enum PClass{
        FIRST,
        SECOND,
        THIRD
    }
    private Long id;

    private Boolean survived;

    private PClass pClass;

    private String name;

    private Boolean sex;

    private Integer age;

    private Integer siblingsAndSpousesAboard;

    private Integer parentsAndChildrenAboard;

    private Integer fare;
}
