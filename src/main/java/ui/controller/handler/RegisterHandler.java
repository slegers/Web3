package ui.controller.handler;

import model.domain.Person;
import model.domain.PersonFactory;
import model.domain.ShopService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class RegisterHandler extends ShopServiceRequestHandler {

    public RegisterHandler(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonFactory factory = new PersonFactory();
        ArrayList<String> fouten = new ArrayList<>();
        Person p = factory.create(request,fouten);

        if(fouten.size() == 0){
            getShopService().addPerson(p);
            response.sendRedirect("/ShopController?action=home");

        }else{
            request.setAttribute("fouten",fouten);
            request.getRequestDispatcher("signUp.jsp").forward(request,response);
        }
    }
}
