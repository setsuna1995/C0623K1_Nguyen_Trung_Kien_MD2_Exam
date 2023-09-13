package service;



import java.util.Scanner;

public class ExceptionManager {
    private static final Scanner sc = new Scanner(System.in);

    public static int exceptionQuantity() {
        int quantity = -1;
        do {
            System.out.println("Enter the quantity of product:");
            try {
                quantity = Integer.parseInt(sc.nextLine());
                if (quantity <= 0) {
                    quantity = -1;
                    System.out.println("Quantity of the product must be greater than zero, please re-enter!!!");
                }
            } catch (NumberFormatException e) {
                System.err.println("Enter numbers only, please re-enter!!!");
            }

        } while (quantity == -1);
        return quantity;
    }

    public static double exceptionPrice() {
        double price = -1.0;
        do {
            System.out.println("Enter the price of product: ");
            try {
                price = Double.parseDouble(sc.nextLine());
                if (price <= 0) {
                    price = -1;
                    System.err.println("Price of the product must be greater than zero, please re-enter!!!");
                }
            } catch (NumberFormatException e) {
                System.err.println("Enter numbers only, please re-enter!!!");
            }

        } while (price == -1);
        return price;
    }

    public static int exceptionPositiveInteger() {
        int number = -1;
        do {
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number <= 0) {
                    number = -1;
                    System.out.println("Id of the product must be greater than zero, please re-enter!!!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong format, you need to enter a positive integer, please enter again!");
            }
        } while (number < 0);
        return number;
    }
    public static int exceptionChoice() {
        int choice = -1;
        do {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 0) {
                    choice = -1;
                    System.err.println("Enter the options available on the screen, please re-enter!!!");
                }
            } catch (NumberFormatException e) {
                System.err.println("Enter the wrong format, re-enter!!!");
            }
        } while (choice == -1);
        return choice;
    }
}

