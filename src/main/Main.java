package main;

import main.entity.Product;
import main.repositories.ProductRepoIMPL;
import main.repositories.ProductRepositories;
import main.repositories.ReceiptRepositories;
import main.repositories.ReceiptRepositoriesIMPL;
import main.view.MainView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ProductRepoIMPL instance = ProductRepoIMPL.getInstance();
        instance.add(new Product("Indomie", 3500L));
        instance.add(new Product("Teh Botol", 4000L));
        instance.add(new Product("Sabun Mandi", 2500L));

        MainView mainView = new MainView();
        mainView.show();
    }
}