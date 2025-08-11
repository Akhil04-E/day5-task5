package Task5;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private double balance;
    private List<String> transactionHistory;

    public Account() {
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: " + amount);
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance.");
        }
    }

    // Check balance
    public double getBalance() {
        return balance;
    }

    // Show transaction history
    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }


    public static void main(String[] args) {
        Account acc = new Account();

        acc.deposit(5000);
        acc.withdraw(10000);
        acc.deposit(2000);
        acc.withdraw(10000);  // should fail

        System.out.println("Current Balance: " + acc.getBalance());

        acc.printTransactionHistory();
    }
}