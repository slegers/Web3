package ui.controller.handler;

import model.domain.DomainException;
import model.domain.Product;
import model.domain.ShopService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteProductPage extends ShopServiceRequestHandler {
    public deleteProductPage(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = getShopService().getProduct(id);
            request.setAttribute("product",product);
            System.out.println(product.getProductId() + "  sdfqsdfqsdf");
            request.getRequestDispatcher("confirmProductDelete.jsp").forward(request,response);
        }catch (NumberFormatException e){
            throw new DomainException("The given id isn't correct");
        }
    }
}
