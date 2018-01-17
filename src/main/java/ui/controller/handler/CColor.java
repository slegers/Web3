package ui.controller.handler;

import model.domain.ShopService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CColor extends ShopServiceRequestHandler {
    public CColor(ShopService service) {
        super(service);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Wanneer de eerste coockie leeg is wordt deze in de for loop rood.
        if(request.getCookies().length == 1){
            response.addCookie(new Cookie("color","geel.css"));
        }
        for(Cookie c : request.getCookies()){
            if(c.getName().equals("color")){
                if(c.getValue().equals("rood.css")){
                    response.addCookie(new Cookie("color","geel.css"));
                }else{
                    response.addCookie(new Cookie("color","rood.css"));
                }
            }
        }
        String url = request.getHeader("Referer");
        response.sendRedirect(url);
    }
}
