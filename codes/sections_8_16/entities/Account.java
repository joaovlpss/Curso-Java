package sections_8_16.entities;

import sections_8_16.exceptions.EntityException;

public class Account {
    protected int number;
    protected String holder;
    protected double balance;
    protected double withdrawLimit;

    public Account(int number, String holder, double balance, double withdrawLimit){
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public double getBalance(){
        return balance;
    }

    public String getHolder(){
        return holder;
    }

    public void setHolder(String newHolder){
        holder = newHolder;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int newNumber){
        number = newNumber;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public void withdraw(double amount) throws EntityException{
        if (amount > withdrawLimit){
            throw new EntityException("Withdraw amount exceeds limit.");
        }
        if (amount > balance) {
            throw new EntityException("Withdraw amount exceeds account balance.");
        }

        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "Account Number: " + number + "\n" +
               "Holder: " + holder + "\n" +
               "Balance: " + String.format("%.2f", balance) + "\n" +
               "Withdraw Limit: " + String.format("%.2f", withdrawLimit);
    }
}
