package ui.controller;

import model.domain.DomainException;
import model.domain.ShopService;
import ui.controller.handler.*;

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
        service = new ShopService(getServletContext());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            String action = request.getParameter("action");
            ShopServiceRequestHandler handler = null;
            switch (action){
                case "home":
                    handler = new HomeHandler(service);
                    break;
                case "personOverview":
                    handler = new PersonOverviewHandler(service);
                    break;
                case "signUpPage":
                    handler = new SignUpPageHandler(service);
                    break;
                case "register":
                    handler = new RegisterHandler(service);
                    break;
                case "productOverview":
                    handler = new ProductOverviewHandler(service);
                    break;
                case "addProduct":
                    handler = new AddProductPageHandler(service);
                    break;
                case "registerProduct":
                    handler = new RegisterProductHandler(service);
                    break;
                case "updateProductPage":
                    handler = new updateProductPageHandler(service);
                    break;
                case "updateProduct":
                    handler = new UpdateProduct(service);
                    break;
                case "deleteProductPage":
                    handler = new deleteProductPage(service);
                    break;
                case "deleteProduct":
                    handler = new deleteProduct(service);
                    break;
                case "deletePersonPage":
                    handler = new deletePersonPage(service);
                    break;
                case "deletePerson":
                    handler = new deletePerson(service);
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
