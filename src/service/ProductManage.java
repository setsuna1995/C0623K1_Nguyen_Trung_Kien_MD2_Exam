package service;

import model.Product;

import java.io.*;
import java.util.*;

public class ProductManage {
    private final Scanner scanner;
    private final ArrayList<Product> productList;

    public ProductManage() {
        scanner = new Scanner(System.in);
        productList = new ArrayList<>();
    }


    public void display() {
        for (Product p : productList
        ) {
            System.out.println(p);
        }
    }

    public void loadProduct(ArrayList<String[]> arrayList) {
        for (String[] strings : arrayList) {
            int id = Integer.parseInt(strings[0]);
            String name = strings[1];
            double price = Double.parseDouble(strings[2]);
            int quantity = Integer.parseInt(strings[3]);
            String des = strings[4];
            Product product = new Product(id, name, price, quantity, des);
            productList.add(product);
        }
    }
    public void add() {
        System.out.println("Enter product ID: ");
        int id = ExceptionManager.exceptionPositiveInteger();
        if (checkID(id) != null) {
            System.out.println("Enter product name: ");
            String name = scanner.nextLine();
            System.out.println("Enter product price: ");
            double price = ExceptionManager.exceptionPrice();
            System.out.println("Enter product quantity: ");
            int quantity = ExceptionManager.exceptionQuantity();
            System.out.println("Enter product description: ");
            String description = scanner.nextLine();
            Product product = new Product(id, name, price, quantity, description);
            productList.add(product);
        }
        else {
            System.out.println("Product already exists");
        }
    }
public Product checkID (int id) {
    for (Product p: productList
         ) {
        if (p.getId() != id) {
            return p;
        }
    }
    return null;
}
    public void edit() {
        display();
        System.out.println("Enter product ID need edit: ");
        int id = ExceptionManager.exceptionPositiveInteger();
        Product product = checkProduct(id);
        if ( product == null) {
            System.out.println("Product not found");
        } else {
            System.out.println("Enter product name: ");
            String name = scanner.nextLine();
            double price = ExceptionManager.exceptionPrice();
            int quantity = ExceptionManager.exceptionQuantity();
            System.out.println("Enter product description: ");
            String description = scanner.nextLine();
            product.setName(name);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setDescription(description);
            System.out.println("Edit successful");
        }
    }

    public Product checkProduct(int id) {
        for (Product p : productList
        ) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void remove() {
        display();
        System.out.println("Enter product ID need remove: ");
        int id = ExceptionManager.exceptionPositiveInteger();
        if (checkProduct(id) == null) {
            System.out.println("Product not found");
        } else {
            System.out.println("Enter Y if you are sure you want to delete");
            String choice = scanner.nextLine();
            if (choice.equals("Y")) {
                productList.remove(checkProduct(id));
            }
        }
    }

    public void sortAscending() {
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }

        });
    }

    public void sortDescending() {
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o2.getPrice() - o1.getPrice());
            }
        });
    }

    public void findMaxPrice() {
        Product product = new Product();
        for (Product p : productList
        ) {
            if (p.getPrice() > product.getPrice()) {
                product.setPrice(p.getPrice());
            }
        }
        ArrayList<Product> arrayList = new ArrayList<>();
        arrayList.add(product);
        System.out.println(arrayList);
        arrayList.remove(product);
    }

    public void writeProduct() {
        try {
            File fileOutClasses = new File("product.cvs");
            BufferedWriter brProduct = new BufferedWriter(new FileWriter(fileOutClasses));
            for (Product p : productList) {
                brProduct.write(p.getId() + "," +
                        p.getName() + "," +
                        p.getPrice() + "," +
                        p.getQuantity() + "," +
                        p.getDescription() + "\n");
            }
            brProduct.close();
        } catch (IOException | NullPointerException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
    }
    public ArrayList<String[]> readProduct (String linkFile) {
        ArrayList<String[]> listData = new ArrayList<>();
        try {
            File file = new File(linkFile);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listData.add(line.split(","));
            }
        } catch (IOException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
        return listData;
    }
}