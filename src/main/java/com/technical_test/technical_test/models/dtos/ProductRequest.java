package com.technical_test.technical_test.models.dtos;

import java.util.List;

public class ProductRequest {

    private List<ProductSalesDto> productSales;
    private List<ProductStockDto> productStock;
    private Double salesWeight;
    private Double stockWeight;

    public List<ProductSalesDto> getProductSales() {
        return productSales;
    }

    public void setProductSales(List<ProductSalesDto> productSales) {
        this.productSales = productSales;
    }

    public List<ProductStockDto> getProductStock() {
        return productStock;
    }

    public void setProductStock(List<ProductStockDto> productStock) {
        this.productStock = productStock;
    }

    public double getSalesWeight() {
        return salesWeight;
    }

    public void setSalesWeight(double salesWeight) {
        this.salesWeight = salesWeight;
    }

    public double getStockWeight() {
        return stockWeight;
    }

    public void setStockWeight(double stockWeight) {
        this.stockWeight = stockWeight;
    }
}
