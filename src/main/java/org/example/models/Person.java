package org.example.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Person {

    private int id;

    @NotEmpty(message = "ФИО не должно быть пустым")
    @Size(min = 2, max = 100, message = "Длина ФИО от 2 до 200 символов")
    private String fullName;

    @Min(value = 1900, message = "Год рождения должен быть больше 1900")
    private int birthYear;

    public Person() {
    }

    public Person(String fullName, int birthYear) {
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

}
