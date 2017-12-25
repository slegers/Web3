package ui.controller.handler;

import model.domain.Product;
import model.domain.ProductFactory;
import model.domain.ShopService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class RegisterProductHandler extends ShopServiceRequestHandler {
    public RegisterProductHandler(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> fouten = new ArrayList<>();
        ProductFactory factory = new ProductFactory();
        try{
            Product p = factory.create(request,fouten);
            getShopService().addProduct(p);
        }catch (NumberFormatException e){
            fouten.add(e.getMessage());
        }
        if(fouten.size() == 0){
            response.sendRedirect("ShopController?action=productOverview");
        }else{
            request.setAttribute("fouten",fouten);
            request.getRequestDispatcher("addProduct.jsp").forward(request,response);
        }
    }
}
