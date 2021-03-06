package ui.controller.handler;

import model.db.DbException;
import model.domain.*;
import ui.controller.handler.ShopServiceRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AddToCart extends ShopServiceRequestHandler {
    public AddToCart(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> fouten = new ArrayList<>();
        Product p;
        CartItem cartItem = null;
        try {
           CartItemFactory factory = new CartItemFactory();
           p = getShopService().getProduct(Integer.parseInt(request.getParameter("id")));
           cartItem = factory.createCartItem(request, fouten, p);
       }catch (NumberFormatException e){
           fouten.add("The quantity should be an number.");
       }
        if(fouten.size() > 0){
            request.setAttribute("fouten",fouten);
            request.getRequestDispatcher("productOverview.jsp").forward(request,response);
        }else{
            addToCart(request,fouten,cartItem);
            response.sendRedirect("ShopController?action=productOverview");
        }
    }

    private void addToCart(HttpServletRequest request, ArrayList<String> fouten, CartItem cartItem) {
            Person person = (Person) request.getSession().getAttribute("user");
            person.addToCart(cartItem);
    }

}
