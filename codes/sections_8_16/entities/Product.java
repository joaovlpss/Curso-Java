package sections_8_16.entities;

public class Product {
    protected String name;
    protected double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    
    public String priceTag() {
        return String.format("$%.2f", price); // Assuming the price is in USD
    }
    
    @Override
    public String toString(){
        return "Product = " + name + ", price = " + Double.toString(price);
    }
}
