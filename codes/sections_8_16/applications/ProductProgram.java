package sections_8_16.applications;

import java.util.Scanner;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import sections_8_16.entities.Product;
import sections_8_16.entities.ImportedProduct;
import sections_8_16.entities.UsedProduct;
import sections_8_16.entities.util.ValidityCheck;

public class ProductProgram {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        StringBuilder sb = new StringBuilder();
        List<Product> prodList = new ArrayList<Product>();


        System.out.print("Insert the number of products: ");
        int count = ValidityCheck.getValueI(sc, "", 1, 999);

        int accumulator = 1;
        for(int i = 0; i < count; i++){
            sb.append("Insert product #");
            sb.append(accumulator);
            sb.append("'s name: ");
            System.out.print(sb.toString());
            String name = sc.nextLine();
            sb.setLength(0);

            sb.append("Insert product #");
            sb.append(accumulator);
            sb.append("'s price: ");
            System.out.print(sb.toString());
            double price = ValidityCheck.getValueI(sc, "", 1.0, 9999.00);
            sb.setLength(0);

            char isSpecialProduct;
            while (true) {
                sb.append("Is product #");
                sb.append(accumulator);
                sb.append(" common, used or imported?(C/U/I): ");
                System.out.print(sb.toString());
                String response = sc.nextLine().toUpperCase();
                sb.setLength(0);
        
                if (response.equals("C") || response.equals("U") || response.equals("I")) {
                    isSpecialProduct = response.charAt(0);
                    break;
                }
        
                System.out.println("Invalid input! Please enter C, U or I.");
            }

            if (isSpecialProduct == 'C'){
                Product product = new Product(name, price);
                prodList.add(product);
            }
            else{
                if (isSpecialProduct == 'U'){
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    boolean isValidDate = false;
                
                    while(!isValidDate){
                    sb.append("Add product #");
                    sb.append(accumulator);
                    sb.append("'s manufacture date(DD/MM/YYYY): ");                
                    System.out.print(sb.toString());
                    String dateInput = sc.nextLine();
                    sb.setLength(0);

                    try {
                        LocalDate date = LocalDate.parse(dateInput, dtf);
                        Product product = new UsedProduct(name, price, date);
                        prodList.add(product);
                        isValidDate = true;
                    } catch (Exception e){
                        System.out.println("Invalid date format. Please try again.");
                    }
                    }
                } else {
                    sb.append("Add product #");
                    sb.append(accumulator);
                    sb.append("'s customs fee: ");                
                    System.out.print(sb.toString());
                    double customsFee = ValidityCheck.getValueI(sc, "", 1.00, 1000.00);
                    sb.setLength(0);

                    Product product = new ImportedProduct(name, price, customsFee);
                    prodList.add(product);
                }
            }

            accumulator++;
        }

        System.out.println("PRODUCT PRICE TAGS:");
        for(Product prod : prodList){
            sb.append(prod.getName()).append(prod.priceTag());
            System.out.println(sb.toString());
            sb.setLength(0);
        }
        sc.close();
    }
}
