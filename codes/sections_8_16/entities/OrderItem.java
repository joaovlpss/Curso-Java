package sections_8_16.entities;

public class OrderItem {
    private int quantity;
    private double price;
    private Product product;

    public OrderItem(int quantity, Product product){
        this.quantity = quantity;
        this.product = product;
        this.price = product.getPrice();
    }

    public void addProducts(int i){
        this.quantity += i;
    }

    public void removeProducts(int i){
        this.quantity -= i;
    }

    public Product getProduct(){
        return product;
    }
    public double subTotal(){
        return quantity * price;
    }
}
