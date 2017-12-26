package ui.controller.handler;

import model.domain.ShopService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class updateProductPageHandler extends ShopServiceRequestHandler {
    public updateProductPageHandler(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> fouten = new ArrayList<>();
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("product",getShopService().getProduct(id));
        }catch (NumberFormatException e){
            fouten.add("Dit product Id is niet van het type int.");
        }catch (NullPointerException e){
            fouten.add("Bij dit product id behoort geen product.");
        }
        if(fouten.size() > 0){
            request.setAttribute("fouten",fouten);
        }
        request.setAttribute("action","updateProduct&id=" + request.getParameter("id"));
        request.getRequestDispatcher("addProduct.jsp").forward(request,response);
    }
}
