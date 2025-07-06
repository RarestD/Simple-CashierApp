package main.services;

import main.entity.CartItem;
import main.entity.Product;
import main.entity.Receipt;
import main.repositories.ProductRepoIMPL;
import main.repositories.ProductRepositories;
import main.repositories.ReceiptRepositoriesIMPL;
import main.util.FileCreate;
import main.util.PropertiesReader;
import main.util.ReceiptBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CashierService {

    private static CashierService instance;

    ProductRepositories productRepositories = ProductRepoIMPL.getInstance();
    ReceiptRepositoriesIMPL receiptRepositories = ReceiptRepositoriesIMPL.getInstance();

    List<CartItem> cartItems = new ArrayList<CartItem>();

    public static CashierService getInstance() {
        if (instance == null) {
            instance = new CashierService();
        }
        return instance;
    }

    public void displayCartItems() {
        double total = 0;
        System.out.println("===== Shopping Cart =====");
        for (CartItem item : cartItems) {
            System.out.printf("%s x%d = Rp %,.2f\n", item.getProduct().getName(), item.getQuantity(), item.getTotalPrice());
            total += item.getTotalPrice();
        }
        System.out.printf("Total: Rp %,.2f\n", total);
    }

    public void addItemToCart(Product product, int quantity) {
        CartItem cartItem = new CartItem(product, quantity);
        cartItems.add(cartItem);
    }

    public void addProductToCartItem(int id, int quantity) {
        try {
            id -= 1;
            Product product = productRepositories.getProduct(id);
            addItemToCart(product, quantity);
        }catch (IndexOutOfBoundsException e) {
            System.out.println("there is no such product");
        }catch (Exception e) {
            System.out.println("error while adding product");
        }
    }



    public double getTotal() {
        return cartItems.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public Receipt checkOut(double paid){
        Integer index = Integer.valueOf(PropertiesReader.get("receipt.id.last"));
        int current = index+1;
        PropertiesReader.set("receipt.id.last", String.valueOf(current));
        String id = String.format("TRX-%04d", index);
        Receipt.Builder receipt = new Receipt.Builder();
        double total = 0.0;
        for (int i =0 ; i < cartItems.size();i++) {
            receipt.addProduct(cartItems.get(i));
            total += cartItems.get(i).getTotalPrice();
        }
        receipt.setSubTotal(total);
        receipt.setPaid(paid);
        receipt.setTransactionId(id);
        receipt.setTimestamp();
        receipt.calculate();
        Receipt build = receipt.build();
        receiptRepositories.add(build);
        cartItems.clear();
        return build;
    }

    public void printReceipt(Receipt receipt) throws IOException {
        String fileName = "src/resources/receipts/"+receipt.getTransactionId() + ".txt";
        String content = ReceiptBuilder.buildReceipt(receipt);
        FileCreate.createFile(fileName);
        FileCreate.writeFile(fileName, content);
    }

}
