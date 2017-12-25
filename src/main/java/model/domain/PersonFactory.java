package model.domain;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class PersonFactory {

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
