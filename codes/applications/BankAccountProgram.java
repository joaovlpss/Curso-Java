package applications;
import entities.BankAccount;
import java.util.Scanner;
import java.util.Locale;

public class BankAccountProgram {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        BankAccount bk = new BankAccount();

        System.out.print("Insert the account holder's name: ");
        String name = sc.nextLine();
        bk.setAccountHolder(name);

        System.out.print("Insert the account number (must be an integer): ");
        int number = sc.nextInt();
        bk.setAccountNumber(number);

        System.out.print("Will the account have an initial value? Answer Y/N: ");
        char initialValue = sc.next().charAt(0);
        if (initialValue == 'Y' || initialValue == 'y'){
            System.out.print("Insert the amount to be added into the account: ");
            double amount = sc.nextDouble();
            bk.depositToAccount(amount);
            System.out.print("Account created successfully!");
        }

        
        int choice;
        do {
            System.out.printf("Welcome, %s!", bk.getAccountHolder());
            choice = menu(sc);
            switch (choice){
                case 1:
                    System.out.println("Insert the amount to be deposited: ");
                    bk.depositToAccount(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Insert the amount to be withdrawn (THERE IS A $5 FEE FOR EVERY WITHDRAW): ");
                    bk.withdrawFromAccount(sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Insert the new account holder's name: ");
                    bk.setAccountHolder(sc.nextLine());
                    break;
                case 4:
                    break;
            }
            
        } while (choice != 4 && choice != -1);
        sc.close();
    }

    public static int menu(Scanner sc){


        System.out.println("Insert your choice:");
        System.out.println("1 - Deposit money in the account.");
        System.out.println("2 - Withdraw money from account.");
        System.out.println("3 - Change account holder name.");
        System.out.println("4 - Exit.");
        int choice = sc.nextInt();
        sc.nextLine(); 

        if (choice >= 1 && choice <= 4){ 
            return choice;
        }
        else {
            return -1;
        }
    }
}


