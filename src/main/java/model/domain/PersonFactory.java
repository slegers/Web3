package model.domain;

import org.apache.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class PersonFactory {

    public PersonFactory(){
        
    }
    
    public Person create(HttpServletRequest request, ArrayList<String> fouten){
        Person p = new Person();
        processFirstName(p,request,fouten);
        processLastName(p,request,fouten);
        processEmail(p,request,fouten);
        processPassWord(p,request,fouten);
        return p;
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
            p.setPassword(request.getParameter("email"));
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
            p.setPassword(request.getParameter("firstName"));
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
            p.setPassword(request.getParameter("lastName"));
        }catch (NullPointerException e){
            fouten.add(e.getMessage());
        }catch (IllegalArgumentException e){
            fouten.add(e.getMessage());
        }catch (DomainException e){
            fouten.add(e.getMessage());
        }
    }

}
