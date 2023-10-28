package sections_8_16.applications;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

import sections_8_16.entities.Client;

public class OrderingProgram_WIP {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        sc.close();
    }

    public static Client promptForClient(Scanner sc){
        System.out.println("ENTER CLIENT INFORMATION:");
        System.out.print("ENTER CLIENT NAME: ");
        String name = sc.nextLine().strip();

        System.out.print("ENTER CLIENT EMAIL: ");
        String email = sc.nextLine().strip();

        System.out.print("ENTER CLIENT BIRTH DATE (DD/MM/YYYY): ");
        LocalDate birthDate = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            birthDate = LocalDate.parse(sc.nextLine(), dtf);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Please use the format DD/MM/YYYY.");
        }

        if (birthDate != null) {
            Client client = new Client(name, email, birthDate);
            return client;
        }
        return new Client(null, null, null);
    }
}
