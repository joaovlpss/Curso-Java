package entities;

public class BankAccount {
    private double accountBalance;
    private String accountHolder;
    private int accountNumber;

    public BankAccount(){}

    public BankAccount(double accountBalance, String accountHolder, int accountNumber){
        this.accountBalance = accountBalance;
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountHolder, int accountNumber){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        accountBalance = 0.00;
    }


    public double getAccountBalance(){
        return accountBalance;
    }


    public int getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder(){
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
    }
    
    public void withdrawFromAccount(double amount){
        accountBalance -= (amount + 5);
    }

    public void depositToAccount(double amount){
        accountBalance += amount;
    }
}
