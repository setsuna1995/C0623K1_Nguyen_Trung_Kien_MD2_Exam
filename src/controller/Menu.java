package controller;

import service.ExceptionManager;
import service.ProductManage;



public class Menu {
    private final ProductManage productManage;

    public Menu() {
        productManage = new ProductManage();
    }

    public void menuManage() {
        int choice;
        do {
            System.out.println("---- Product management program ----");
            System.out.println("1. Show list : ");
            System.out.println("2. Add: ");
            System.out.println("3. Update: ");
            System.out.println("4. Remove: ");
            System.out.println("5. Sort: ");
            System.out.println("6. Find max price: ");
            System.out.println("7. Read file: ");
            System.out.println("8. Write file: ");
            System.out.println("9. Exit: ");
            System.out.println("Choose function: ");
            choice = ExceptionManager.exceptionChoice();
            switch (choice) {
                case 1:
                    productManage.display();
                    break;
                case 2:
                    System.out.println("1. Add: ");
                    productManage.display();
                    choice = ExceptionManager.exceptionChoice();
                    if (choice == 1) {
                        productManage.add();
                    }
                    break;
                case 3:
                    productManage.edit();
                    break;
                case 4:
                    productManage.remove();
                    break;
                case 5:
                    System.out.println("1. Sort up ascending: ");
                    System.out.println("2. Sort descending: ");
                    System.out.println("3. Exit.");
                    choice = ExceptionManager.exceptionChoice();
                    if (choice == 1) {
                        productManage.sortAscending();
                    } else if (choice == 2) {
                        productManage.sortDescending();
                    }
                    break;
                case 6:
                    productManage.findMaxPrice();
                    break;
                case 7:
                    productManage.loadProduct(productManage.readProduct("product.cvs"));
                    break;
                case 8:
                    productManage.writeProduct();
                    break;
            }
        } while (choice != 9);
    }
}

