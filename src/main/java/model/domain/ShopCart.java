package model.domain;

import java.util.Collection;
import java.util.HashMap;

public class ShopCart {
    private HashMap<Integer,CartItem> shopCart;


    public ShopCart(){
        shopCart = new HashMap<>();
    }
    public void add(CartItem cartItem) {
        if(shopCart.containsKey(cartItem.getProduct().getProductId())){
            CartItem item = shopCart.get(cartItem.getProduct().getProductId());
            item.setQuantity(item.getQuantity() + cartItem.getQuantity());
            shopCart.put(cartItem.getProduct().getProductId(),item);
        }else{
            shopCart.put(cartItem.getProduct().getProductId(),cartItem);
        }
    }

    public int getSize() {
        return shopCart.size();
    }
    public Collection<CartItem> getItems(){
        return  shopCart.values();
    }

    public void replace(CartItem cartItem) {
        shopCart.put(cartItem.getProduct().getProductId(),cartItem);
    }

    public void delete(CartItem cartItem) {
        shopCart.remove(cartItem.getProduct().getProductId());
    }

    public void delete(int id) {
        shopCart.remove(id);
    }

    public void pay() {
        shopCart.clear();
    }
}
