package main.repositories;

import main.entity.Receipt;

import java.util.ArrayList;
import java.util.List;

public class ReceiptRepositoriesIMPL implements ReceiptRepositories {

    private static ReceiptRepositoriesIMPL instance;

    List<Receipt> receipts = new ArrayList<>();

    public static ReceiptRepositoriesIMPL getInstance() {
        if (instance == null) {
            instance = new ReceiptRepositoriesIMPL();
        }
        return instance;
    }

    @Override
    public void add(Receipt receipt) {
        receipts.add(receipt);
    }

    @Override
    public Receipt getReceipt(String id) {
        for (Receipt receipt : receipts) {
            receipt.getTransactionId().equals(id);
            return receipt;
        }
        return null;
    }

    @Override
    public void remove(String id) {
        for (Receipt receipt : receipts) {
            receipt.getTransactionId().equals(id);
            receipts.remove(receipt);
            System.out.println("receipt removed");
            return;
        }
        System.out.println("Receipt not found");
    }
}
