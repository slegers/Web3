package ui.controller.handler;

import model.domain.*;
import ui.controller.handler.ShopServiceRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class DeleteFromCart extends ShopServiceRequestHandler {
    public DeleteFromCart(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> fouten = new ArrayList<>();
        Product p = getShopService().getProduct(Integer.parseInt(request.getParameter("id")));
        if(fouten.size() > 0){
            request.setAttribute("fouten",fouten);
            request.getRequestDispatcher("productOverview.jsp").forward(request,response);
        }else{
            delete(request,fouten,p.getProductId());
            response.sendRedirect("ShopController?action=productOverview");
        }
    }

    private void delete(HttpServletRequest request, ArrayList<String> fouten, int id) {
        Person person = (Person) request.getSession().getAttribute("user");
        person.deleteInCart(id);
    }
}
