package sections_8_16.applications;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

import sections_8_16.entities.Product;
import sections_8_16.entities.Client;
import sections_8_16.entities.Order;
import sections_8_16.entities.OrderItem;
import sections_8_16.entities.util.ValidityCheck;
import sections_8_16.entities.enums.OrderStatus;

public class OrderingProgram {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        Client orderClient = promptForClient(sc);
        Order newOrder = promptForOrder(sc, orderClient);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("ORDER SUMMARY:");
        System.out.println("ORDER MOMENT: " +
                        dtf.format(newOrder.getMoment()));
        System.out.println("ORDER STATUS: " +
                        newOrder.getStatus());
        System.out.println("ORDER CLIENT: " +
                        orderClient.toString());
        System.out.println("ORDER ITEMS: ");
        for(OrderItem i : newOrder.getOrderItems()){
            System.out.println(i.getProduct().toString());
        }
        System.out.println("TOTAL PRICE: " +
                            newOrder.total());
        sc.close();
    }

    public static Client promptForClient(Scanner sc){
        System.out.println("ENTER CLIENT INFORMATION:");
        System.out.print("ENTER CLIENT NAME: ");
        String name = sc.nextLine().strip();

        System.out.print("ENTER CLIENT EMAIL: ");
        String email = sc.nextLine().strip();

        // Loops until a valid date is entered.
        System.out.print("ENTER CLIENT BIRTH DATE (DD/MM/YYYY): ");
        LocalDate birthDate = null;
        boolean valid = false;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do {
            try {
                birthDate = LocalDate.parse(sc.nextLine(), dtf);
                valid = true; 
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format! Please use the format DD/MM/YYYY.");
            }
        } while (!valid);
        


        if (birthDate != null) {
            Client client = new Client(name, email, birthDate);
            return client;
        }
        return new Client(null, null, null);
    }

    public static Order promptForOrder(Scanner sc, Client orderClient){
        LocalDateTime orderMoment = LocalDateTime.now();
        OrderStatus status = OrderStatus.PENDING_PAYMENT;
        System.out.println("ENTER ORDER DATA:");
        System.out.println("ORDER STATUS: " + status.toString());
        int id = ValidityCheck.getValueI(sc, "ORDER ID: ", 1, 999);
        int orderItemQuantity = ValidityCheck.getValueI(sc, "HOW MANY ITEMS TO THIS ORDER: ", 1, 999);
        
        Order newOrder = new Order(id, orderMoment, status, orderClient);
        
        int accumulator = 1;
        for (int i = 0; i < orderItemQuantity; i++){
            System.out.print("ENTER PRODUCT #" + 
                            accumulator +
                            " NAME: ");
            String name = sc.nextLine();
            System.out.print("ENTER PRODUCT #" +
                             accumulator +
                             " PRICE: ");
            double itemPrice = ValidityCheck.getValueI(sc, "", 0.00, 9999.99);
            System.out.print("ENTER PRODUCT #" +
                            accumulator +
                            " QUANTITY: ");
            int quantity = ValidityCheck.getValueI(sc, "", 1, 999);

            Product pd = new Product(name, itemPrice);
            OrderItem ot = new OrderItem(quantity, pd);

            accumulator++;
            newOrder.addItem(ot);
        }

        return newOrder;
    }
}
