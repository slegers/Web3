package model.db;

import model.domain.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDbInMemory {
	private Map<String, Person> persons = new HashMap<String, Person>();
	
	public PersonDbInMemory () {
		Person administrator = new Person("admin", "admin@ucll.be", "t", "Ad", "Ministrator");
		Person administrator2 = new Person("admin2", "admin2@ucll.be", "t2", "Ad2", "Ministrato2r");

		add(administrator);
		add(administrator2);

	}
	
	public Person get(String personId){
		if(personId == null){
			throw new DbException("No id given");
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
	
	public void delete(String personId){
		if(personId == null){
			throw new DbException("No id given");
		}
		persons.remove(personId);
	}
}
