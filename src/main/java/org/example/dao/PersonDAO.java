package org.example.dao;

import org.example.models.Book;
import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new BeanPropertyRowMapper<>(Person.class),
                new Object[]{id}).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person (full_name, birth_year) VALUES (?,?)",
                person.getFullName(), person.getBirthYear());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET full_name=?, birth_year=? WHERE id=?",
                updatedPerson.getFullName(), updatedPerson.getBirthYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

    public Optional<Person> getPersonByFullName(String fullName) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE full_name=?", new Object[]{fullName},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public List<Book> getBooksByPersonId(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id = ?",
                new BeanPropertyRowMapper<>(Book.class), id);
    }

}
