package main.repositories;

import main.entity.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ProductRepoIMPL implements ProductRepositories{

    // Singleton instance
    private static ProductRepoIMPL instance;

    private static final ArrayList<Product> products = new ArrayList<>();

    private ProductRepoIMPL() {}

    public static ProductRepoIMPL getInstance() {
        if (instance == null) {
            instance = new ProductRepoIMPL();
        }
        return instance;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Product getProduct(int id) {
        return products.get(id);
    }

    @Override
    public void edit(Product product, int id) {
        products.set(id-1, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id-1);
    }

}
