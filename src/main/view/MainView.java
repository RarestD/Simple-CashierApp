package main.view;

import main.entity.Receipt;
import main.util.Input;
import main.util.PropertiesReader;

import java.io.IOException;

public class MainView {



    public void show() throws IOException {
        while(true) {
            System.out.println("===== Cashier " + PropertiesReader.get("store.name") + " App  =====");
            System.out.println("==== MENU ====");
            System.out.println("1. Show all products");
            System.out.println("2. Add product to cart");
            System.out.println("3. Check cart");
            System.out.println("4. Check out");
            System.out.println("5. Add Product");
            System.out.println("6. Remove Product");
            System.out.println("x. Exit");
            String s = Input.inputString("> Select an option");
            switch (s.toLowerCase()) {
                case "1":
                    ProductsView.showAllProducts();
                    break;
                case "2":
                    CartView.addToCart();
                    break;
                case "3":
                    CartView.showCart();
                    break;
                case "4":
                    ReceiptView.checkOutView();
                    break;
                case "5":
                    ProductsView.addProduct();
                    break;
                case "6":
                    ProductsView.removeProduct();
                    break;
                case "x":
                    return;
                default :
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

}
