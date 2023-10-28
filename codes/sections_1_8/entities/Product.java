package sections_1_8.entities;

public class Product {
    public String name;
    public double price;
    public int quantity;

    public Product(){
    }
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
  

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double totalValueInStock() {
            return price * quantity;
    }

    public void addProducts(int quantity){
        this.quantity += quantity;
    }

    public void removeProducts(int quantity){
        this.quantity -= quantity;
    }

    public String toString(){ // Sobrepondo a toString de Object.
        return String.format("%s, $ %.2f, Quantity = %d, Total = %.2f", 
                            name, price, quantity, quantity * price);
    }
}
