package ui.controller;

import model.domain.DomainException;
import model.domain.ShopService;
import ui.controller.handler.HomeHandler;
import ui.controller.handler.PersonOverviewHandler;
import ui.controller.handler.ShopServiceRequestHandler;
import ui.controller.handler.SignUpPageHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ShopController")
public class ShopController extends HttpServlet {
    private ShopService service;
    public ShopController(){
        super();
    }


    public void init(){
        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        service = new ShopService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            String action = request.getParameter("action");
            ShopServiceRequestHandler handler = null;
            System.out.println(action);
            switch (action){
                case "home":
                    handler = new HomeHandler(service);
                    break;
                case "p":
                    handler = new PersonOverviewHandler(service);
                    break;
                case "signUpPage":
                    handler = new SignUpPageHandler(service);
                    break;
                default:
                    handler = new HomeHandler(service);
                    break;
            }
            handler.handle(request,response);
        } catch (ServletException e) {
            throw new DomainException("De gevraagde pagina kon niet worden gevonden. " + e.getMessage());
        } catch (IOException e) {
            throw new DomainException("De gevraagde pagina kon niet worden gevonden. " + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request,response);
    }
}
