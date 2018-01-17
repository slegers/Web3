package model.db;

import model.domain.Person;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public interface dbPersonInterface {
    Person get(int personId);

    ArrayList<Person> getAll();

    void add(Person person);

    void update(Person person);

    void delete(int personId);

    Person getPersonByEmail(String email) throws NotImplementedException;
}
