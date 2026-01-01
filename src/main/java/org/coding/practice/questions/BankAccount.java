package org.coding.practice.questions;

// Create a class "BankAccount" with attributes account number and balance.
// Implement methods to deposit and withdraw funds, and a display method to show the account details.

public class BankAccount {
    String accountNumber;
    double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double withdrawFunds(double amount) {
        if(balance <= amount) {
            System.out.println("Insufficient funds");
            return 0.0d;
        }

        balance -= amount;

        return amount;
    }

    public double depositFunds(double amount) {
        balance += amount;

        return amount;
    }

    public String accountDetails(String accountNumber) {

        System.out.println(
                "You're account number is " + accountNumber +
                " and you're balance as of now is " + balance
        );

        return "123";
    }
}
