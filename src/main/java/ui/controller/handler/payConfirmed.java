package ui.controller.handler;

import model.domain.ShopService;
import ui.controller.handler.ShopServiceRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class payConfirmed extends ShopServiceRequestHandler {
    public payConfirmed(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("payConfirmed.jsp").forward(request,response);
    }
}
