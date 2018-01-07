package ui.controller.handler;

import model.domain.DomainException;
import model.domain.Person;
import model.domain.ShopService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deletePersonPage extends ShopServiceRequestHandler {
    public deletePersonPage(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            Person p = getShopService().getPerson(id);
            request.setAttribute("person",p);
            request.getRequestDispatcher("confirmPersonDelete.jsp").forward(request,response);
        }catch (NumberFormatException e){
            throw new DomainException("The given id isn't correct");
        }
    }
}
