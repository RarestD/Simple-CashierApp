package main.repositories;

import main.entity.Receipt;

public interface ReceiptRepositories {

    void add(Receipt receipt);

    Receipt getReceipt(String id);

    void remove(String id);

}
