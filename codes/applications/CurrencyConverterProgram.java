package applications;
import java.util.Scanner;

public class CurrencyConverterProgram {
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        double currency;

        System.out.print("Insert the number of dollars to be bought: ");
        currency = sc.nextDouble();

        System.out.printf("Number of reais to be paid = %.2f", entities.util.CurrencyConverter.calculate(currency));

        sc.close();
    }
    
}
