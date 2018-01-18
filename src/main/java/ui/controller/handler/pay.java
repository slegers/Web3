package ui.controller.handler;

import model.domain.Person;
import model.domain.ShopService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class pay extends ShopServiceRequestHandler {
    public pay(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person p = (Person) request.getSession().getAttribute("user");
        getShopService().pay(p);
        response.sendRedirect("/ShopController?action=payConfirmed");
    }
}
