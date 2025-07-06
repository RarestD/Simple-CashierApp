package main.view;

import main.entity.Receipt;
import main.services.CashierService;
import main.util.Input;

import java.io.IOException;

public class ReceiptView {

    static CashierService cashierService = CashierService.getInstance();

    public static void checkOutView() throws IOException {
        if (cashierService.getTotal() < 1){
            System.out.println("No Product on the Cart");
            return;
        }
        CartView.showCart();
        System.out.printf("Bayar: Rp ");
        double bayar = Double.parseDouble(Input.inputString());
        double total = cashierService.getTotal();
        if (bayar >= total) {
            System.out.printf("Kembalian: Rp %,.2f\n", bayar - total);
            Receipt receipt = cashierService.checkOut(bayar);
            printReceipt(receipt);
        } else {
            System.out.println("Uang tidak cukup.");
        }
    }

    public static void printReceipt(Receipt receipt) throws IOException {
        System.out.println( "=".repeat(40));
        String inputted = Input.inputString("Do you want to print Receipt? (Y/N): ");
        switch (inputted.toLowerCase()){
            case "yes":
                cashierService.printReceipt(receipt);
                break;
            case "y":
                cashierService.printReceipt(receipt);
                break;
            case "no":
                return;
            case "n":
                return;
            default:
                System.out.println("Input tidak valid");
                System.out.println("answer with yes or no (Y/N)");
        }
    }

}
