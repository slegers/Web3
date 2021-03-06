package model.domain;

import model.db.DbException;
import model.domain.exceptions.DomainException;

import javax.servlet.http.HttpServletRequest;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonFactory {


    public Person create(ResultSet result){
        Person p = new Person();
        try {
            p.setUserid(result.getInt("persoon_id"));
            p.setEmail(result.getString("email"));
            p.setFirstName(result.getString("fname"));
            p.setLastName(result.getString("lname"));
            p.setAlreadyHashedPassword(result.getString("password"));
            p.setSalt(result.getString("salt"));
            p.setRole(result.getString("role"));
        } catch (SQLException e) {
            throw new DbException("Couldn't retrieve the persoon_id" + e.getMessage());
        } catch (NumberFormatException e){
            throw new DbException("The persoon_id couldn't be converted to an integer " + e.getMessage());
        }catch (NullPointerException e){
            throw new DbException(e.getMessage() + "sf ");
        }
        return p;
    }

    public Person create(HttpServletRequest request, ArrayList<String> fouten){
        Person p = new Person();
        processId(p,request,fouten);
        processFirstName(p,request,fouten);
        processLastName(p,request,fouten);
        processEmail(p,request,fouten);
        SecureRandom r = new SecureRandom();
        p.setSalt(r.generateSeed(16));
        processPassWord(p,request,fouten);
        //Set the customer role by default
        p.setRole("customer");
        return p;
    }

    private void processId(Person p, HttpServletRequest request, ArrayList<String> fouten) {
        try{
            p.setUserid(Integer.parseInt(request.getParameter("id")));
        }catch (NumberFormatException e){
            fouten.add("This person ID isn't a number");
        }catch (IllegalArgumentException e){
            fouten.add(e.getMessage());
        }
    }

    private void processPassWord(Person p, HttpServletRequest request, ArrayList<String> fouten) {
        try{
            p.setPassword(request.getParameter("password"));
        }catch (NullPointerException e){
            fouten.add(e.getMessage());
        }catch (IllegalArgumentException e){
            fouten.add(e.getMessage());
        }catch (DomainException e){
            fouten.add(e.getMessage());
        }
    }

    private void processEmail(Person p, HttpServletRequest request, ArrayList<String> fouten) {
        try{
            p.setEmail(request.getParameter("email"));
        }catch (NullPointerException e){
            fouten.add(e.getMessage());
        }catch (IllegalArgumentException e){
            fouten.add(e.getMessage());
        }catch (DomainException e){
            fouten.add(e.getMessage());
        }
    }

    private void processFirstName(Person p, HttpServletRequest request, ArrayList<String> fouten) {
        try{
            p.setFirstName(request.getParameter("firstName"));
        }catch (NullPointerException e){
            fouten.add(e.getMessage());
        }catch (IllegalArgumentException e){
            fouten.add(e.getMessage());
        }catch (DomainException e){
            fouten.add(e.getMessage());
        }
    }

    private void processLastName(Person p, HttpServletRequest request, ArrayList<String> fouten) {
        try{
            p.setLastName(request.getParameter("lastName"));
        }catch (NullPointerException e){
            fouten.add(e.getMessage());
        }catch (IllegalArgumentException e){
            fouten.add(e.getMessage());
        }catch (DomainException e){
            fouten.add(e.getMessage());
        }
    }
}
