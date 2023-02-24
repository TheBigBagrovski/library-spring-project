package org.example.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {

    private int id;

    @NotEmpty(message = "Название не должно быть пустым")
    @Size(min = 1, max = 200, message = "Длина названия от 1 до 200 символов")
    private String name;

    @NotEmpty(message = "Имя автора не должно быть пустым")
    @Size(min = 2, max = 100, message = "Длина имени от 2 до 100 символов")
    private String author;

    @Min(value = 0, message = "Год должен быть больше 0")
    private int year;

    public Book() {

    }

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
