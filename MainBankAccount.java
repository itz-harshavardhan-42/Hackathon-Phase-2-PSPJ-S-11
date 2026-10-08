import java.util.Scanner;
class BankAccount {
    // Data members
    private String accountNumber;
    private String accountHolderName;
    private double balance;
// Parameterized constructor
public BankAccount(String accountNumber, String accountHolderName, double balance) {
    this.accountNumber = accountNumber;
    this.accountHolderName = accountHolderName;
    this.balance = balance;
}

// Method to deposit money
public void deposit(double amount) {
    if (amount > 0) {
        balance += amount;
        System.out.printf("Successfully deposited $%.2f. New Balance: $%.2f\n", amount, balance);
    } else {
        System.out.println("Invalid deposit amount. Amount must be positive.");
    }
}

// Method to withdraw money
public void withdraw(double amount) {
    if (amount <= 0) {
        System.out.println("Invalid withdrawal amount. Amount must be positive.");
    } else if (amount <= balance) {
        balance -= amount;
        System.out.printf("Successfully withdrew $%.2f. Remaining Balance: $%.2f\n", amount, balance);
    } else {
        System.out.println("Insufficient balance! Withdrawal failed.");
    }
}

// Method to return current balance
public double checkBalance() {
    return balance;
}

// Method to display account details
public void displayAccount() {
    System.out.println("\n--- Account Details ---");
    System.out.println("Account Number : " + accountNumber);
    System.out.println("Holder Name    : " + accountHolderName);
    System.out.printf("Current Balance: $%.2f\n", balance);
    System.out.println("-----------------------");
}
}
public class MainBankAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    // Read account details from user
    System.out.print("Enter Account Number: ");
    String accNum = scanner.nextLine();

    System.out.print("Enter Account Holder Name: ");
    String accHolder = scanner.nextLine();

    System.out.print("Enter Initial Balance: ");
    double initialBalance = scanner.nextDouble();

    // Create object using parameterized constructor
    BankAccount account = new BankAccount(accNum, accHolder, initialBalance);

    System.out.println("\nAccount initialized successfully!");
    account.displayAccount();

    // Perform Deposit
    System.out.print("\nEnter amount to deposit: ");
    double depositAmount = scanner.nextDouble();
    account.deposit(depositAmount);

    // Perform Withdrawal
    System.out.print("\nEnter amount to withdraw: ");
    double withdrawAmount = scanner.nextDouble();
    account.withdraw(withdrawAmount);

    // Display final account details
    System.out.println("\nFinal Summary:");
    account.displayAccount();

    scanner.close();
}
}