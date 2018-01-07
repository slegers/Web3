package model.db.sql;

import model.db.DbException;
import model.db.dbProductInterface;
import model.db.memory.ProductDbInMemory;
import model.domain.PersonFactory;
import model.domain.Product;
import model.domain.ProductFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.ServletContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class productSqlDb implements dbProductInterface {
    private Properties properties;
    private String url;
    private ResultSet resultSet;
    private Connection connection;
    private PreparedStatement preparedStatement;
    public productSqlDb(ServletContext context) {
        properties = new Properties();
        url = context.getInitParameter("url");
        properties.setProperty("url",url);
        properties.setProperty("user",context.getInitParameter("user-name"));
        properties.setProperty("password",context.getInitParameter("password"));
        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");

    }

    @Override
    public Product get(int productId) {
        try {
            connection = DriverManager.getConnection(url,properties);
            preparedStatement = connection.prepareStatement("select * from product where id_product = ?");
            preparedStatement.setInt(1,productId);
            resultSet = preparedStatement.executeQuery();
            ProductFactory factory = new ProductFactory();
            resultSet.next();
            Product p = factory.create(resultSet);
            preparedStatement.close();
            connection.close();
            return p;
        } catch (SQLException e) {
            throw new DbException("Couldn't get this specific person");
        }
    }

    @Override
    public ArrayList<Product> getAll() {
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,properties);
            preparedStatement = connection.prepareStatement("Select * from product");
            resultSet = preparedStatement.executeQuery();
            ArrayList<Product> list = new ArrayList<>();
            ProductFactory factory = new ProductFactory();
            while(resultSet.next()){
                list.add(factory.create(resultSet));
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
    public void add(Product product) {
        try{
            connection = DriverManager.getConnection(url,properties);
            preparedStatement = connection.prepareStatement("INSERT INTO product (naam,omschrijving,prijs) values (?,?,?)");
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getDescription());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close()
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void update(Product product) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(int productId) {
        try {
            connection = DriverManager.getConnection(url,properties);
            preparedStatement = connection.prepareStatement("DELETE FROM PRODUCT where id_product = ?");
            preparedStatement.setInt(1,productId);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new DbException("Couldn't get this specific person" + e.getMessage());
        }
    }
}
