package sections_8_16.applications;

import sections_8_16.entities.Account;
import sections_8_16.entities.util.ValidityCheck;
import sections_8_16.exceptions.ApplicationException;
import sections_8_16.exceptions.EntityException;

import java.util.*;

public class AccountProgram {
    private static Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    private static Map<Integer, Account> accountsMap = new HashMap<>();

    public static void main(String[] args){
        int option;
        do {
            menu();
            option = ValidityCheck.getValueI(sc, "Choose an option: ", 1, 4);
            try {
                switch (option) {
                    case 1:
                        registerNewAccounts();
                        break;
                    case 2:
                        listAllAccounts();
                        break;
                    case 3:
                        manipulateAccount();
                        break;
                }
            } catch (ApplicationException | EntityException e) {
                System.out.println(e.getMessage());
            }
        } while (option != 4);

        sc.close();
        System.out.println("Program ended.");
    }

    public static void menu() {
        System.out.println("1 - REGISTER NEW ACCOUNTS.");
        System.out.println("2 - LIST ALL ACCOUNTS.");
        System.out.println("3 - MANIPULATE AN ACCOUNT.");
        System.out.println("4 - EXIT.");
    }

    private static void registerNewAccounts() throws ApplicationException {
        System.out.print("Enter the number of accounts to register: ");
        int numberOfAccounts = sc.nextInt();
        for (int i = 0; i < numberOfAccounts; i++) {
            System.out.print("Enter account number: ");
            int accountNumber = sc.nextInt();
            if (accountsMap.containsKey(accountNumber)) {
                throw new ApplicationException("Account number already exists.");
            }
            sc.nextLine(); // clear buffer
            System.out.print("Enter holder name: ");
            String holder = sc.nextLine();
            System.out.print("Enter initial balance: ");
            double balance = sc.nextDouble();
            System.out.print("Enter withdraw limit: ");
            double withdrawLimit = sc.nextDouble();
    
            Account newAccount = new Account(accountNumber, holder, balance, withdrawLimit);
            accountsMap.put(accountNumber, newAccount);
        }
    }
    
    private static void listAllAccounts() {
        for (Account acc : accountsMap.values()) {
            System.out.println(acc);
            System.out.println("===================");
        }
    }

    private static void manipulateAccount() throws ApplicationException, EntityException {
        System.out.print("Enter account number: ");
        int accountNumber = sc.nextInt();
        Account account = accountsMap.get(accountNumber);

        if (account == null) {
            throw new ApplicationException("Account number does not exist.");
        }

        System.out.println("Account selected: ");
        System.out.println(account);

        System.out.println("1 - Deposit");
        System.out.println("2 - Withdraw");
        System.out.println("3 - Return to main menu");
        System.out.print("Choose an operation: ");
        int operation = sc.nextInt();

        switch (operation) {
            case 1: // Deposit
                System.out.print("Enter deposit amount: ");
                double depositAmount = sc.nextDouble();
                if (depositAmount <= 0) {
                    throw new ApplicationException("Deposit amount must be greater than zero.");
                }
                account.deposit(depositAmount);
                System.out.println("New balance: " + account.getBalance());
                break;
            case 2: // Withdraw
                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = sc.nextDouble();
                if (withdrawalAmount <= 0) {
                    throw new ApplicationException("Withdrawal amount must be greater than zero.");
                }
                account.withdraw(withdrawalAmount);
                System.out.println("New balance: " + account.getBalance());
                break;
            case 3: // Return to main menu
                return;
            default:
                throw new ApplicationException("Invalid operation selected.");
        }
    }
    
}
