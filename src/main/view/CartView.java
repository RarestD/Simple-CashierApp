package main.view;

import main.entity.Product;
import main.repositories.ProductRepoIMPL;
import main.services.CashierService;
import main.util.Input;

import java.util.InputMismatchException;

public class CartView {

    static CashierService cashierService = CashierService.getInstance();

    public static void addToCart() {
        System.out.println("===== Adding Product to Cart =====");
        try {
            int id = Input.inputInt("Select Product Number");
            int quantity = Input.inputInt("Select Quantity");
            cashierService.addProductToCartItem(id, quantity);
        }catch (InputMismatchException e){
            System.out.println("Product number not valid");
        }
    }

    public static void showCart() {
        cashierService.displayCartItems();
    }

}
