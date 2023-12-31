package sections_1_8.applications;
import java.util.Locale;
import java.util.Scanner;

import sections_1_8.entities.Product;

public class ProductProgram {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter product data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Quantity in stock: ");
        int quantity = sc.nextInt();

        Product product = new Product(name, price, quantity);
        System.out.println("Product data:" + product.toString());

        System.out.println();
        System.out.print("Enter the number of products to be added in stock: ");
        int aQuantity = sc.nextInt();
        product.addProducts(aQuantity);
        System.out.println("Updated data:" + product.toString());


        System.out.println();
        System.out.print("Enter the number of products to be added in stock: ");
        int rQuantity = sc.nextInt();
        product.removeProducts(rQuantity);
        System.out.println("Updated data:" + product.toString());
        
        sc.close();
    }
}
