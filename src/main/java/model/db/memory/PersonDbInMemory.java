package model.db.memory;

import model.db.DbException;
import model.db.dbPersonInterface;
import model.domain.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDbInMemory implements dbPersonInterface {
	private Map<Integer, Person> persons = new HashMap<Integer, Person>();
	
	public PersonDbInMemory () {
		Person administrator = new Person(1, "admin@ucll.be", "t", "Ad", "Ministrator");
		Person administrator2 = new Person(2, "admin2@ucll.be", "t2", "Ad2", "Ministrato2r");

		add(administrator);
		add(administrator2);

	}
	
	public Person get(int personId){
		if(!persons.containsKey(personId)){
			throw new DbException("the given id doens't exist in our database.");
		}
		return persons.get(personId);
	}
	
	public ArrayList<Person> getAll(){
		return new ArrayList<Person>(persons.values());	
	}

	public void add(Person person){
		if(person == null){
			throw new DbException("No person given");
		}
		if (persons.containsKey(person.getUserid())) {
			throw new DbException("User already exists");
		}
		persons.put(person.getUserid(), person);
	}
	
	public void update(Person person){
		if(person == null){
			throw new DbException("No person given");
		}
		if(!persons.containsKey(person.getUserid())){
			throw new DbException("No person found");
		}
		persons.put(person.getUserid(), person);
	}
	
	public void delete(int personId){
		persons.remove(personId);
	}
}
