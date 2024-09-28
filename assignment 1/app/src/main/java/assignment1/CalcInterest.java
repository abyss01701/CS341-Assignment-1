package assignment1;

import java.util.Scanner;

public class CalcInterest {

    public static String computeLoanInterest(double loanAmount, int yearLoan, int loanType) {
        double interestRate = 0.0;
        double interest = 0.0;
        double totalAmount = 0.0;

        // Check for invalid input
        if (loanAmount <= 0 || yearLoan <= 0) {
            return "-1"; // Invalid input
        }

        // Determine the interest rate based on loanType, loanAmount, and yearLoan
        if (loanType == 1) { // Home loan
            if (loanAmount < 100000) {
                if (yearLoan <= 5) {
                    interestRate = 0.08;
                } else if (yearLoan <= 10) {
                    interestRate = 0.065;
                } else {
                    interestRate = 0.055;
                }
            } else if (loanAmount < 500000) {
                if (yearLoan <= 10) {
                    interestRate = 0.065;
                } else {
                    interestRate = 0.055;
                }
            } else {
                interestRate = 0.055;
            }
        } else if (loanType == 2) { // Property loan
            if (loanAmount < 100000) {
                if (yearLoan <= 5) {
                    interestRate = 0.12;
                } else if (yearLoan < 10) {
                    interestRate = 0.085;
                } else {
                    interestRate = 0.07;
                }
            } else if (loanAmount < 500000) {
                if (yearLoan < 10) {
                    interestRate = 0.085;
                } else {
                    interestRate = 0.07;
                }
            } else {
                interestRate = 0.07;
            }
        } else {
            return "-1"; // Invalid loan type
        }

        // Calculate interest
        interest = loanAmount * interestRate * yearLoan;

        // Calculate total amount to be paid
        totalAmount = loanAmount + interest;

        // Format the output string to include all required information
        return String.format("Total Amount to be Paid: $%.2f\nTotal Interest: $%.2f\nInterest Rate: %.2f%%\nInterest Term: %d years",
                totalAmount, interest, interestRate * 100, yearLoan);    
    
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collect input from the user
        System.out.println("This is a Interest Loan Calculator");
        System.out.println("1. Home Loan");
        System.out.println("2. Property Loan");
        System.out.println("3. Exit");
        System.out.print("Choose an option between 1-3: ");
        int loanType = scanner.nextInt();
        
        if(loanType == 3)
        {
           System.exit(0);
        }

        System.out.print("Enter loan amount: ");
        double loanAmount = scanner.nextDouble();

        System.out.print("Enter loan term in years: ");
        int yearLoan = scanner.nextInt();

        // Calculate the loan interest and total amount
        String result = computeLoanInterest(loanAmount, yearLoan, loanType);

        // Display the result
        if (result.equals("-1")) {
            System.out.println("Invalid input provided.");
        } else {
            System.out.println(result);
        }

        scanner.close();
    }
}
