package ui.controller.handler;

import model.db.DbException;
import model.domain.Person;
import model.domain.PersonFactory;
import model.domain.ShopService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;

public class Login extends ShopServiceRequestHandler {
    public Login(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{
           Person p = getShopService().getPersonByEmail(request.getParameter("email"));
        if(p != null && p.isCorrectPassword(request.getParameter("password"))){
            HttpSession s  = request.getSession();
            s.setAttribute("user",p);
            response.sendRedirect("/ShopController?action=home");
        }else{
            ArrayList<String> fouten = new ArrayList<>();
            fouten.add("Het emailadres en/of passwoord is fout");
            request.setAttribute("fouten",fouten);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
       }catch (DbException e){
           ArrayList<String> fouten = new ArrayList<>();
           fouten.add("Het emailadres en/of passwoord is fout");
           request.setAttribute("fouten",fouten);
           request.getRequestDispatcher("index.jsp").forward(request,response);
       }
    }
}
