package ui.controller.handler;

import model.domain.DomainException;
import model.domain.ShopService;
import ui.controller.handler.ShopServiceRequestHandler;

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
        }catch (NumberFormatException e){
            throw new DomainException("The given product id cant be found.");
        }
        response.sendRedirect("/ShopController?action=productOverview");
    }
}
