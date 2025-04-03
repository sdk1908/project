package org.example;

import java.math.BigDecimal;

public class Order {
    public Order(String prodName, String prodCategory, BigDecimal prodAmount) {
        this.prodName = prodName;
        this.prodCategory = prodCategory;
        this.prodAmount = prodAmount;
    }

    private String prodName;
    private  String prodCategory;
    private BigDecimal prodAmount;

    public String getProdName() {
        return prodName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "prodName='" + prodName + '\'' +
                ", prodCategory='" + prodCategory + '\'' +
                ", prodAmount=" + prodAmount +
                '}';
    }

    public String getProdCategory() {
        return prodCategory;
    }

    public BigDecimal getProdAmount() {
        return prodAmount;
    }
}
