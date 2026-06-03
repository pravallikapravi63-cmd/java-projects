import java.util.Scanner;

public class Atm {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int correctPin = 1234;
        double balance = 5000;
        int attempts = 3;

        String history = "";

        while (attempts > 0) {
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            if (pin == correctPin) {
                System.out.println("\nLogin Successful!\n");

                while (true) {

                    System.out.println("\n===== ATM MENU =====");
                    System.out.println("1. Check Balance");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Mini Statement");
                    System.out.println("5. Exit");
                    System.out.print("Enter choice: ");

                    int choice = sc.nextInt();

                    if (choice == 1) {
                        System.out.println("Balance: " + balance);
                        history += "Checked balance\n";

                    } else if (choice == 2) {

                        System.out.print("Enter deposit amount: ");
                        double amount = sc.nextDouble();

                        balance += amount;
                        System.out.println("Deposited successfully!");
                        System.out.println("New Balance: " + balance);

                        history += "Deposited " + amount + "\n";

                    } else if (choice == 3) {

                        System.out.print("Enter withdrawal amount: ");
                        double amount = sc.nextDouble();

                        if (amount <= balance) {
                            balance -= amount;
                            System.out.println("Withdrawal Successful!");
                            System.out.println("Remaining Balance: " + balance);

                            history += "Withdrew " + amount + "\n";
                        } else {
                            System.out.println("Insufficient Balance!");
                        }

                    } else if (choice == 4) {

                        System.out.println("\n===== MINI STATEMENT =====");
                        System.out.println(history);

                    } else if (choice == 5) {

                        System.out.println("Thank you for using ATM!");
                        break;

                    } else {
                        System.out.println("Invalid Choice! Try again.");
                    }
                }

                break; // exit PIN loop after success

            } else {
                attempts--;
                System.out.println("Wrong PIN! Attempts left: " + attempts);
            }
        }

        if (attempts == 0) {
            System.out.println("Account locked due to too many wrong attempts.");
        }

        sc.close();
    }
}