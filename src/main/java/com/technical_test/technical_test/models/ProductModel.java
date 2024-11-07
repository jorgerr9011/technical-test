package com.technical_test.technical_test.models;

public class ProductModel {

    private String productId;
    private Double priority;

    public ProductModel(String productId, double priority) {
        this.productId = productId;
        this.priority = priority;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getPriority() {
        return priority;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }
}
