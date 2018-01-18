package ui.controller;

import model.domain.exceptions.DomainException;
import model.domain.ShopService;
import model.domain.exceptions.NotAuthorizedException;
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
            ShopServiceRequestHandler handler;
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
                case "checkPasswordHandlerPage":
                    handler = new checkPasswordHandlerPage(service);
                    break;
                case "checkPassword":
                    handler = new CheckPassword(service);
                    break;
                case "changeColor":
                    handler = new CColor(service);
                    break;
                case "login":
                    handler = new Login(service);
                    break;
                case "logout":
                    handler = new Logout(service);
                    break;
                case "addToCart":
                    handler = new AddToCart(service);
                    break;
                case "showCart":
                    handler = new ShowCart(service);
                    break;
                case "UpdateCart":
                    handler = new UpdateCart(service);
                    break;
                case "DeleteFromCart":
                    handler = new DeleteFromCart(service);
                    break;
                case "confirmOrder":
                    handler = new ConfirmOrder(service);
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
        }catch (NoClassDefFoundError e){
            e.printStackTrace();
        }catch (NotAuthorizedException e){
            throw new NotAuthorizedException("U hebt niet de juiste rechten om deze pagina te bekijken. ");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request,response);
    }
}
