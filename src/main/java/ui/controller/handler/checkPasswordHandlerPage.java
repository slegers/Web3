package ui.controller.handler;

import model.domain.DomainException;
import model.domain.Person;
import model.domain.ShopService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class checkPasswordHandlerPage extends ShopServiceRequestHandler {
    public checkPasswordHandlerPage(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("person", getShopService().getPerson(Integer.parseInt(request.getParameter("id"))));
            request.getRequestDispatcher("checkPass.jsp").forward(request,response);
        } catch (NumberFormatException e) {
            throw new DomainException("ID can't be converted to int");
        }
    }
}
