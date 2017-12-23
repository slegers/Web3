package ui.controller.handler;

import model.domain.DomainException;
import model.domain.ShopService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public  abstract class ShopServiceRequestHandler {

    private ShopService shopService;
    public ShopServiceRequestHandler(ShopService service){
        setShopService(service);

    }
    public abstract void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public void setShopService(ShopService shopService) {
        if(shopService == null){
            throw new DomainException("De shopservice van een handler mag niet null zijn.");
        }
        this.shopService = shopService;
    }

    public ShopService getShopService() {
        return shopService;
    }
}
