package ui.controller.handler;

import model.db.DbException;
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

        try{
            getShopService().addPerson(p);
        }catch (DbException e){
            fouten.add(e.getMessage());
        }
        if(fouten.size() == 0){
            response.sendRedirect("/ShopController?action=home");

        }else{
            for (String f: fouten){
                System.out.println(f);
            }
            request.setAttribute("fouten",fouten);
            request.getRequestDispatcher("signUp.jsp").forward(request,response);
        }
    }
}
