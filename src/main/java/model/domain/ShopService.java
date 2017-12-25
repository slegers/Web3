package model.domain;

import model.db.memory.PersonDbInMemory;
import model.db.memory.ProductDbInMemory;

import java.util.List;


public class ShopService {
	private PersonDbInMemory personDb;
	private ProductDbInMemory productDb;
	public ShopService(){
		personDb = new PersonDbInMemory();
		productDb = new ProductDbInMemory();
	}
	
	public Person getPerson(int personId) {
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

	public Object getProducts() {
		return productDb.getAll();
	}

	public void addProduct(Product p) {
		productDb.add(p);
	}
}
