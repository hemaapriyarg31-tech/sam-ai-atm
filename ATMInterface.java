import java.util.Scanner;

class BankAccount {
    private double balance = 1000;
    private int pin = 1234;

    public boolean validatePin(int enteredPin) {
        return enteredPin == pin;
    }

    public void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ ₹" + amount + " deposited successfully.");
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid amount.");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient Balance.");
        } else {
            balance -= amount;
            System.out.println("✅ ₹" + amount + " withdrawn successfully.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        System.out.print("Enter ATM PIN: ");
        int pin = sc.nextInt();

        if (!account.validatePin(pin)) {
            System.out.println("❌ Incorrect PIN. Access Denied!");
            return;
        }

        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;

                case 3:
                    System.out.print("Enter withdraw amount: ");
                    double wit = sc.nextDouble();
                    account.withdraw(wit);
                    break;

                case 4:
                    System.out.println("🙏 Thank you for using ATM!");
                    break;

                default:
                    System.out.println("❌ Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}