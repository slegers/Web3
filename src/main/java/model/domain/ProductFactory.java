package model.domain;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductFactory {

    public Product create(HttpServletRequest request, ArrayList<String> fouten){
        Product p = new Product();
        processName(p,fouten,request);
        processDescription(p,fouten,request);
        processPrice(p,fouten,request);
        return p;
    }

    private void processPrice(Product p, ArrayList<String> fouten, HttpServletRequest request) {
        try{
            p.setPrice(request.getParameter("price"));
        }catch (NumberFormatException e){
            fouten.add("The price of a product wasn't from the type integer.");
        }catch (DomainException e){
            fouten.add(e.getMessage());
        }
    }

    private void processDescription(Product p, ArrayList<String> fouten, HttpServletRequest request) {
        try{
            p.setDescription(request.getParameter("description"));
        }catch (DomainException e){
                fouten.add(e.getMessage());
        }
    }

    private void processName(Product p, ArrayList<String> fouten, HttpServletRequest request) {
        try{
            p.setName(request.getParameter("name"));
        }catch (DomainException e){
            fouten.add(e.getMessage());
        }

    }

    public Product create(ResultSet resultSet) {
        Product p = new Product();
        try{
            p.setProductId(resultSet.getInt("id_product"));
            p.setPrice(resultSet.getString("prijs"));
            p.setDescription(resultSet.getString("omschrijving"));
            p.setName(resultSet.getString("naam"));
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
