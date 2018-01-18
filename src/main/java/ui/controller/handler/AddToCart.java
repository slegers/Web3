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
        CartItem cartItem = new CartItem();
        processQuantity(request,fouten,cartItem);
        Product p = getProduct(request,cartItem,fouten);
        if(fouten.size() > 0){
            addToCart(request,p,fouten,cartItem);
            request.setAttribute("fouten",fouten);
            request.getRequestDispatcher("productOverview.jsp").forward(request,response);
        }else{
            response.sendRedirect("ShopController?action=productOverview");
        }
    }

    private void addToCart(HttpServletRequest request, Product p, ArrayList<String> fouten, CartItem cartItem) {
            Person person = (Person) request.getSession().getAttribute("user");
            person.addToCart(p,cartItem);
    }

    private Product getProduct(HttpServletRequest request, CartItem cartItem, ArrayList<String> fouten) {
        Product p;
        try{
            p = getShopService().getProduct(Integer.parseInt(request.getParameter("id")));
            cartItem.setProduct(p);
            return p;
        }catch (NumberFormatException e){
            fouten.add("The id of the product should be a number.");
        }catch (NullPointerException e){
            fouten.add(e.getMessage());
        }catch (DbException e){
            fouten.add(e.getMessage());
        }
        return null;
    }

    private void processQuantity(HttpServletRequest request, ArrayList<String> fouten,CartItem cart) {
        try{
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            if(quantity < 1){
                fouten.add("The minimum quantity must be larger than zero.");
            }else{
                cart.setQuantity(quantity);
            }
        }catch (NumberFormatException e){
            fouten.add("The quantity should be an number.");
        }
    }
}
