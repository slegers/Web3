package ui.controller.handler;

import model.domain.Person;
import model.domain.Role;
import model.domain.ShopService;
import model.domain.exceptions.NotAuthorizedException;
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
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.admin);
        Person p = (Person) request.getSession().getAttribute("user");
        if(p != null && p.hasAccess(roles)){
            request.getRequestDispatcher("personOverview.jsp").forward(request,response);
        }else{
            throw new NotAuthorizedException("Deze persoon heeft geen recht op persoonsoverzicht.");
        }

    }
}
