package ui.controller.handler;

import model.db.DbException;
import model.domain.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class UpdateCart extends ShopServiceRequestHandler {
    public UpdateCart(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String>  fouten = new ArrayList<>();
        CartItem cartItem = null;
        boolean ex = true;
         try {
            CartItemFactory factory = new CartItemFactory();
            Product p = getShopService().getProduct(Integer.parseInt(request.getParameter("id")));
            if (Integer.parseInt(request.getParameter("quantity")) == 0) {
                 ex = false;
                 deleteFromCartById(request,fouten,Integer.parseInt(request.getParameter("id")));
            }else{
                cartItem = factory.createCartItem(request, fouten, p);
            }
        }catch (NumberFormatException e){
            fouten.add("The quantity is not a number.");
        }if(fouten.size() > 0){
            request.setAttribute("fouten",fouten);
            request.getRequestDispatcher("productOverview.jsp").forward(request,response);
        }else{
            if(ex){
                replaceInCart(request,fouten,cartItem);
            }
            response.sendRedirect("ShopController?action=showCart");
        }

    }

    private void deleteFromCartById(HttpServletRequest request, ArrayList<String> fouten, int id) {
        Person person = (Person) request.getSession().getAttribute("user");
        person.deleteInCart(id);
    }

    private void replaceInCart(HttpServletRequest request, ArrayList<String> fouten, CartItem cartItem) {
        Person person = (Person) request.getSession().getAttribute("user");
        person.replaceInCart(cartItem);
    }



}
