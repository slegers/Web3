package model.domain;

import model.db.PersonDbInMemory;
import model.db.ProductDbInMemory;

import java.util.List;


public class ShopService {
	private PersonDbInMemory personDb;
	private ProductDbInMemory productDb;
	public ShopService(){
		personDb = new PersonDbInMemory();
		productDb = new ProductDbInMemory();
	}
	
	public Person getPerson(String personId) {
		return getPersonDb().get(personId);
	}

	public List<Person> getPersons() {
		return getPersonDb().getAll();
	}

	public void addPerson(Person person) {
		getPersonDb().add(person);
	}

	public void updatePersons(Person person) {
		getPersonDb().update(person);
	}

	public void deletePerson(String id) {
		getPersonDb().delete(id);
	}

	private PersonDbInMemory getPersonDb() {
		return personDb;
	}
}
