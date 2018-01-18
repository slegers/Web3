package ui.controller.handler;

import model.domain.Person;
import model.domain.Role;
import model.domain.ShopService;
import model.domain.exceptions.NotAuthorizedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ProductOverviewHandler extends ShopServiceRequestHandler {

    public ProductOverviewHandler(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products",getShopService().getProducts());
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.admin);
        roles.add(Role.customer);
        Person p = (Person) request.getSession().getAttribute("user");
        int numbOfCartItems = p.getNumbOfCartItems();
        if(p != null && p.hasAccess(roles)){
            request.setAttribute("cartItems",numbOfCartItems);
            request.getRequestDispatcher("productOverview.jsp").forward(request,response);
        }else{
            throw new NotAuthorizedException("De persoon in kwestie is niet toegelaten " +
                    "tot het bekijken van het product overzicht");
        }

    }
}
