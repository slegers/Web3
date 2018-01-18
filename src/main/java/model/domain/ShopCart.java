package model.domain;

import java.util.Collection;
import java.util.HashMap;

public class ShopCart {
    private HashMap<Integer,CartItem> shopCart;


    public ShopCart(){
        shopCart = new HashMap<>();
    }
    public void add(Product p, CartItem cartItem) {
        if(shopCart.containsKey(p.getProductId())){
            CartItem item = shopCart.get(p.getProductId());
            item.setQuantity(item.getQuantity() + cartItem.getQuantity());
            shopCart.put(p.getProductId(),item);
        }else{
            shopCart.put(p.getProductId(),cartItem);
        }
    }

    public int getSize() {
        return shopCart.size();
    }
    public Collection<CartItem> getItems(){
        return  shopCart.values();
    }
}
