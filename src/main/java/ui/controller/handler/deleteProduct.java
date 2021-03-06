package ui.controller.handler;

import model.domain.exceptions.DomainException;
import model.domain.ShopService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteProduct extends ShopServiceRequestHandler {
    public deleteProduct(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            getShopService().deleteProduct(id);
            response.sendRedirect("/ShopController?action=productOverview");
        }catch (NumberFormatException e){
            throw new DomainException("The given product id cant be found.");
        }
    }
}
