package model.domain;

import java.util.HashMap;

public class ShopCart {
    private HashMap<Integer,CartItem> shopCart;


    public ShopCart(){
        shopCart = new HashMap<>();
    }
    public void add(Product p, CartItem cartItem) {
        shopCart.put(p.getProductId(),cartItem);
    }

    public int getSize() {
        return shopCart.size();
    }
}
