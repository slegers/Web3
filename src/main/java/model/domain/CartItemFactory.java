package model.domain;

import model.db.DbException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class CartItemFactory {

    public CartItem createCartItem(HttpServletRequest request, ArrayList<String> fouten,Product p) {
        CartItem c = new CartItem();
        processQuantity(request,fouten,c);
        processProduct(request,c,fouten,p);
        return c;
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
    private void processProduct(HttpServletRequest request, CartItem cartItem, ArrayList<String> fouten, Product p) {
        try{
            cartItem.setProduct(p);
        }catch (NumberFormatException e){
            fouten.add("The id of the product should be a number.");
        }catch (NullPointerException e){
            fouten.add(e.getMessage());
        }catch (DbException e){
            fouten.add(e.getMessage());
        }
    }
}
