package sections_17_20.applications;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import sections_17_20.entities.Contract;
import sections_17_20.services.ContractInstallmentService;
import sections_17_20.services.PaypalPaymentService;

public class ContractProgram {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        DateTimeFormatter tmf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter contract data");
        System.out.print("Number: ");
        Integer number = sc.nextInt();

        System.out.print("Date (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), tmf);

        System.out.print("Contract value: ");
        Double totalValue = sc.nextDouble();

        System.out.print("Enter number of installments: ");

        Integer months = sc.nextInt();

        Contract contract = new Contract(number, date, totalValue);

        ContractInstallmentService cis = new ContractInstallmentService(contract, new PaypalPaymentService(), months);
        cis.processContract();

        System.out.println("Installments:");
        for (int i = 0; i < contract.getInstallments().size(); i++){
            System.out.println(contract.getInstallments().get(i).toString());
        }

        sc.close();
    }
}
