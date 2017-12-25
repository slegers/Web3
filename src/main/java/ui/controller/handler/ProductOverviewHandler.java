package ui.controller.handler;

import model.domain.ShopService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductOverviewHandler extends ShopServiceRequestHandler {

    public ProductOverviewHandler(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products",getShopService().getProducts());
        request.getRequestDispatcher("productOverview.jsp").forward(request,response);
    }
}
