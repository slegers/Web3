package ui.controller.handler;

import model.domain.Product;
import model.domain.ProductFactory;
import model.domain.ShopService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.util.ArrayList;

public class UpdateProduct extends ShopServiceRequestHandler {
    public UpdateProduct(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> fouten = new ArrayList<>();
        ProductFactory factory = new ProductFactory();
        Product p = factory.create(request,fouten);
        try{
            p.setProductId(Integer.parseInt(request.getParameter("id")));
            getShopService().deleteProduct(p.getProductId());
            getShopService().addProduct(p);
        }catch (NullPointerException e){
            fouten.add("The product id isn't know to our database.");
        }catch (NumberFormatException e){
            fouten.add("the requested id can't be converted to the type int.");
        }
        if(fouten.size() < 1){
            response.sendRedirect("/ShopController?action=productOverview");
        }else{
            request.setAttribute("fouten",fouten);
            request.setAttribute("product",p);
            request.getRequestDispatcher("addProduct.jsp").forward(request,response);
        }

    }
}
