package ui.controller.handler;

import com.thoughtworks.selenium.condition.Not;
import model.domain.Person;
import model.domain.Role;
import model.domain.ShopService;
import model.domain.exceptions.NotAuthorizedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowCart extends ShopServiceRequestHandler {
    public ShowCart(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {
          Person p = (Person) request.getSession().getAttribute("user");
          request.setAttribute("cartItems", p.getCart().getItems());
          ArrayList<Role> roles = new ArrayList<>();
          roles.add(Role.admin);
          roles.add(Role.customer);
          if (p != null && p.hasAccess(roles)) {
              request.getRequestDispatcher("shopCart.jsp").forward(request, response);
          }
      }catch (NotAuthorizedException e){
          throw new NotAuthorizedException(e.getMessage());
      }


    }
}