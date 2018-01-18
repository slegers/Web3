package model.domain;

public class CartItem {

    private Product product;
    private int quantity;

    public CartItem(){

    }
    public CartItem(Product p, int quantity){
        setProduct(p);
    }

    public void setProduct(Product product) {
        if(product == null){
            throw new NullPointerException("The product of a cart can't be null.");
        }
        this.product = product;
    }

    public void setQuantity(int quantity) {
        if(quantity < 1){
            throw new IllegalArgumentException("The quantity of a cart should alwas be more then zero.");
        }
        this.quantity = quantity;
    }
    public Product getProduct(){
        return product;
    }
    public int getQuantity(){
        return quantity;
    }
}
