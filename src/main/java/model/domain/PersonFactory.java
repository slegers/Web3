package model.domain;

import model.db.DbException;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonFactory {


    public Person create(ResultSet result){
        Person p = new Person();
        try {
            p.setUserid(Integer.parseInt(result.getString("persoon_id")));
            p.setEmail(result.getString("email"));
            p.setFirstName(result.getString("fname"));
            p.setLastName(result.getString("lname"));
            p.setPassword(result.getString("password"));
        } catch (SQLException e) {
            throw new DbException("Couldn't retrieve the persoon_id");
        } catch (NumberFormatException e){
            throw new DbException("The persoon_id couldn't be converted to an integer");
        }catch (NullPointerException e){
            throw new DbException(e.getMessage());
        }
        return p;
    }

    public Person create(HttpServletRequest request, ArrayList<String> fouten){
        Person p = new Person();
        processId(p,request,fouten);
        processFirstName(p,request,fouten);
        processLastName(p,request,fouten);
        processEmail(p,request,fouten);
        processPassWord(p,request,fouten);
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
