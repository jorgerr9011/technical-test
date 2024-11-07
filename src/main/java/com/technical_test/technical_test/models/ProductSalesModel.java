package com.technical_test.technical_test.models;

public class ProductSalesModel {

    private String productId;

    private Double sales;

    public ProductSalesModel(){}

    public ProductSalesModel(String productId, Double sales) {
        this.productId = productId;
        this.sales = sales;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }
}
