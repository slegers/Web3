package model.domain;

import model.db.dbPersonInterface;
import model.db.dbProductInterface;
import model.db.memory.PersonDbInMemory;
import model.db.memory.ProductDbInMemory;
import model.db.sql.PersonSqlDb;
import model.db.sql.productSqlDb;

import javax.servlet.ServletContext;
import java.util.List;


public class ShopService {
	private dbPersonInterface personDb;
	private dbProductInterface productDb;
	public ShopService(ServletContext context){
	//	personDb = new PersonDbInMemory();
	//	productDb = new ProductDbInMemory();
		personDb = new PersonSqlDb(context);
		productDb = new productSqlDb(context);
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


	public void deletePerson(int id) {
		getPersonDb().delete(id);
	}

	private dbPersonInterface getPersonDb() {
		return personDb;
	}

	public List<Product> getProducts() {
		return productDb.getAll();
	}

	public void addProduct(Product p) {
		productDb.add(p);
	}

    public Product getProduct(int id) {
		return productDb.get(id);
    }

	public void deleteProduct(int id) {
		productDb.delete(id);
	}

    public Person getPersonByEmail(String email) {
		return personDb.getPersonByEmail(email);
    }
}
