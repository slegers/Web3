package model.db;

import model.domain.Product;

import java.util.ArrayList;

public interface dbProductInterface {

    Product get(int productId);

    ArrayList<Product> getAll();

    void add(Product product);

    void update(Product product);

    void delete(int productId);

}
