package main.view;

import main.entity.Product;
import main.repositories.ProductRepoIMPL;
import main.util.Input;

import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;

public class ProductsView {

    private static ProductRepoIMPL productRepo = ProductRepoIMPL.getInstance();


    public static void showAllProducts() {
        System.out.println("=================================================");
        System.out.println("All products");
        int index = 0;
        for (Product product : productRepo.getAllProducts()){
            System.out.printf("%d. %s - Rp %,.2f\n", index+1, productRepo.getProduct(index).getName(), productRepo.getProduct(index).getPrice());
            index++;
        }
        System.out.println("=================================================");
    }


    public static void addProduct() {
        System.out.println("===== Adding Product =====");
        try {
            String name = Input.inputString("Insert Product Name");
            double price = Input.inputDouble("Insert Product Price");
            productRepo.add(new Product(name, price));
            System.out.println("Successfully added product " + name);
        }catch (InputMismatchException e){
            System.out.println("Product price not valid");
        }
    }

    public static void removeProduct() {
        System.out.println("===== Removing Product =====");
        try {
            int id = Input.inputInt("Select Product Number");
            productRepo.remove(id);
            System.out.println("Successfully remove product " + id);
        }catch (InputMismatchException e){
            System.out.println("Product number not valid");
        }
    }


}
