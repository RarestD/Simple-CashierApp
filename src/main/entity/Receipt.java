package main.entity;

import main.util.PropertiesReader;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private String storeName = PropertiesReader.get("store.name");
    private String transactionId;
    private LocalDateTime timestamp;
    private List<CartItem> datas;
    private double subtotal;
    private double tax = Double.parseDouble(PropertiesReader.get("store.tax"));
    private double total;
    private double paid;
    private double change;

    // Only buildable via Builder
    private Receipt(Builder builder) {
        this.storeName = builder.storeName;
        this.transactionId = builder.transactionId;
        this.timestamp = builder.timestamp;
        this.datas = builder.datas;
        this.subtotal = builder.subtotal;
        this.tax = builder.tax;
        this.total = builder.total;
        this.paid = builder.paid;
        this.change = builder.change;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public List<CartItem> getDatas() {
        return datas;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }

    public double getPaid() {
        return paid;
    }

    public double getChange() {
        return change;
    }

    public static class Builder {
        private String storeName = PropertiesReader.get("store.name");
        private String transactionId;
        private LocalDateTime timestamp;
        private double subtotal;
        private double tax;
        private double total;
        private double paid;
        private double change;
        private List<CartItem> datas =  new ArrayList<>();

        public Builder addProduct(CartItem product) {
            this.datas.add(product);
            return this;
        }

        public Builder setSubTotal(double subtotal) {
            this.subtotal = subtotal;
            return this;
        }

        public Builder setTransactionId(String id) {
            this.transactionId = id;
            return this;
        }

        public Builder setPaid(double paid) {
            this.paid = paid;
            return this;
        }

        public Builder setTimestamp() {
            this.timestamp = LocalDateTime.now();
            return this;
        }

        public Builder calculate() {
            double ppn = Integer.parseInt(PropertiesReader.get("store.tax")) * 0.01;
            this.tax = subtotal * ppn;
            this.total = subtotal + tax;
            this.change = paid - total;
            return this;
        }

        public Receipt build() {
            return new Receipt(this);
        }
    }

}
