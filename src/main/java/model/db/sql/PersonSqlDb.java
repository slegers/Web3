package model.db.sql;

import model.db.DbException;
import model.db.dbPersonInterface;
import model.domain.DomainException;
import model.domain.Person;
import model.domain.PersonFactory;

import javax.servlet.ServletContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class PersonSqlDb implements dbPersonInterface {

    private String url;
    private Properties properties;
    private PreparedStatement preparedStatement;
    private ResultSet result;
    private Connection connection;

    public PersonSqlDb(ServletContext context){
        Properties properties = new Properties();
        url = context.getInitParameter("url");
        properties.setProperty("url",url);
        properties.setProperty("user",context.getInitParameter("user"));
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

            PersonFactory factory = new PersonFactory(result);

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
        return null;
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
