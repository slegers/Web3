package ui.controller.handler;

import model.domain.exceptions.DomainException;
import model.domain.ShopService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deletePerson extends ShopServiceRequestHandler {
    public deletePerson(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            getShopService().deletePerson(Integer.parseInt(request.getParameter("id")));
            response.sendRedirect("/ShopController?action=personOverview");
        }catch (NumberFormatException e){
            throw new DomainException("The given product id cant be found.");
        } }
}
