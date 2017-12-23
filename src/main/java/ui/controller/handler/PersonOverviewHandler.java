package ui.controller.handler;

import model.domain.Person;
import model.domain.ShopService;
import ui.controller.handler.ShopServiceRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonOverviewHandler extends ShopServiceRequestHandler {
    public PersonOverviewHandler(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("persons",getShopService().getPersons());
        request.getRequestDispatcher("personOverview.jsp").forward(request,response);
    }
}
