package main.repositories;

import main.entity.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepositories {

    List<Product> getAllProducts();

    void add(Product product);

    Product getProduct(int id);

    void edit(Product product, int id);

    void remove(int id);


}
