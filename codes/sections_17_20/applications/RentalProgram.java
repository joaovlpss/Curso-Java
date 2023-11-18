package sections_17_20.applications;

import sections_17_20.entities.Vehicle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import sections_17_20.entities.CarRental;
import sections_17_20.services.BrazilTaxService;
import sections_17_20.services.RentalService;

public class RentalProgram {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    System.out.println("Enter rental data");
    System.out.print("Car model: ");
    String carModel = sc.nextLine();

    System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
    LocalDateTime startDate = LocalDateTime.parse(sc.nextLine(), fmt);

    System.out.print("Return (dd/MM/yyyy hh:mm): ");
    LocalDateTime finishDate = LocalDateTime.parse(sc.nextLine(), fmt);

    System.out.print("Enter price per hour: ");
    double pricePerHour = sc.nextDouble();

    System.out.print("Enter price per day: ");
    double pricePerDay = sc.nextDouble();

    CarRental carRental = new CarRental(startDate, finishDate, new Vehicle(carModel));
    RentalService rs = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
    
    rs.processInVoice(carRental);

    System.out.println("INVOICE:");
    System.out.println("Basic payment: " + String.format("%.2f", carRental.getInVoice().getBasicPayment()));
    System.out.println("Tax: " + String.format("%.2f", carRental.getInVoice().getTax()));
    System.out.println("Total payment: " + String.format("%.2f", carRental.getInVoice().getTotalPayment()));
    
    sc.close(); 
    }
}
