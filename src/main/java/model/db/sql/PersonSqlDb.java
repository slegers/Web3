package model.db.sql;

import model.db.DbException;
import model.db.dbPersonInterface;
import model.domain.Person;
import model.domain.PersonFactory;

import javax.servlet.ServletContext;
import javax.validation.constraints.Null;
import java.sql.*;
import java.util.ArrayList;
import java.util.*;

public class PersonSqlDb implements dbPersonInterface {

    private String url;
    private PreparedStatement preparedStatement;
    private Properties properties;
    private ResultSet result;
    private Connection connection;

    public PersonSqlDb(ServletContext context){
        properties = new Properties();
        url = context.getInitParameter("url");
        properties.setProperty("url",url);
        properties.setProperty("user",context.getInitParameter("user-name"));
        properties.setProperty("password",context.getInitParameter("password"));
        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
    }

    @Override
    public Person get(int personId) {
        try {
            connection = DriverManager.getConnection(url,properties);
            preparedStatement = connection.prepareStatement("select * from persoon where persoon_id = ?");
            preparedStatement.setInt(1,personId);
            result = preparedStatement.executeQuery();
            PersonFactory factory = new PersonFactory();
             return  factory.create(result);
        } catch (SQLException e) {
            throw new DbException("Couldn't get this specific person");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DbException("Couldn't close the database connection for this specific person");
            }
        }
    }

    @Override
    public ArrayList<Person> getAll() {
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,properties);
            preparedStatement = connection.prepareStatement("SELECT * FROM persoon");
            result = preparedStatement.executeQuery();
            PersonFactory factory = new PersonFactory();
            ArrayList<Person> p = new ArrayList<>();

            while(result.next()){
                p.add(factory.create(result));
            }
            return p;
        }catch (DbException e){
            throw new DbException(e.getMessage());
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }catch (NullPointerException e){
            throw new DbException("Er is geen connectie mogelijk met de DB.");
        } catch (ClassNotFoundException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void add(Person person) {

    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(int personId) {

    }
}
