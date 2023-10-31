package sections_8_16.entities;

public class ImportedProduct extends Product {
    private double customsFee;

    public ImportedProduct(String name, double price, double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(double customsFee) {
        this.customsFee = customsFee;
    }

    public double totalPrice() {
        return getPrice() + customsFee;
    }

    // Overriding the priceTag method
    @Override
    public String priceTag() {
        return String.format("$%.2f (Customs Fee = $%.2f)", totalPrice(), customsFee);
    }
}
