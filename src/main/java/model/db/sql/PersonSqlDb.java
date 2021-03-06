package model.db.sql;

import model.db.DbException;
import model.db.dbPersonInterface;
import model.domain.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,properties);
            preparedStatement = connection.prepareStatement("select * from persoon where persoon_id = ?");
            preparedStatement.setInt(1,personId);
            result = preparedStatement.executeQuery();
            PersonFactory factory = new PersonFactory();
            result.next();
            Person p = factory.create(result);
            preparedStatement.close();
            connection.close();
            return  p;
        } catch (SQLException e) {
            throw new DbException("Couldn't get this specific person " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new DbException("The postgres driver wasn't found");
        }
    }

    @Override
    public ArrayList<Person> getAll() {
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,properties);
            preparedStatement = connection.prepareStatement("Select * from persoon");
            result = preparedStatement.executeQuery();
            ArrayList<Person> list = new ArrayList<>();
            PersonFactory factory = new PersonFactory();
            while(result.next()){
                list.add(factory.create(result));
            }
            preparedStatement.close();
            connection.close();
            return list;
        } catch (ClassNotFoundException e) {
            throw new DbException(e.getMessage());
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void add(Person person) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,properties);
            preparedStatement = connection.prepareStatement("INSERT INTO persoon(email,fname,lname,password,salt,role) values(?,?,?,?,?,?)");
            preparedStatement.setString(1,person.getEmail());
            preparedStatement.setString(2,person.getFirstName());
            preparedStatement.setString(3,person.getLastName());
            preparedStatement.setString(4,person.getPassword());
            preparedStatement.setString(5,person.getSalt());
            preparedStatement.setString(6, "customer");
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new DbException("Couldn't get this specific person " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new DbException("The postgres driver wasn't found");
        }
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(int personId) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,properties);
            preparedStatement = connection.prepareStatement("DELETE FROM PERSOON where persoon_id = ?");
            preparedStatement.setInt(1,personId);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new DbException("The postgres driver wasn't found");
        }
    }

    @Override
    public Person getPersonByEmail(String email){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,properties);
            preparedStatement = connection.prepareStatement("select * from persoon where email = ?");
            preparedStatement.setString(1,email.toLowerCase());
            result = preparedStatement.executeQuery();
            PersonFactory factory = new PersonFactory();
            result.next();
            Person p = factory.create(result);
            preparedStatement.close();
            connection.close();
            return  p;
        } catch (SQLException e) {
            throw new DbException("Couldn't get this specific person " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new DbException("The postgres driver wasn't found");
        }
    }
}
