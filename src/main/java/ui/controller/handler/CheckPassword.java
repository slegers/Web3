package ui.controller.handler;

import model.domain.DomainException;
import model.domain.Person;
import model.domain.ShopService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckPassword extends ShopServiceRequestHandler {
    public CheckPassword(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Person p = getShopService().getPerson(Integer.parseInt(request.getParameter("id")));
            String s;
           if(p.isCorrectPassword(request.getParameter("password"))){
               s= "Password is OK";
           }else{
               s = "Password is NOK";
           }
           request.setAttribute("person",p);
           request.setAttribute("tekst",s);
           request.getRequestDispatcher("checkPass.jsp").forward(request,response);
        }catch (NumberFormatException e){
            throw new DomainException("The id can't be converted to an integer");
        }
    }
}
