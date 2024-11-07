package com.technical_test.technical_test.models;

public class ProductStockModel {

    private String productId;

    private Integer stock;

    public ProductStockModel(){}

    public ProductStockModel(String productId, Integer stock) {
        this.productId = productId;
        this.stock = stock;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
