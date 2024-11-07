package com.technical_test.technical_test.services.impl;

import com.technical_test.technical_test.models.ProductModel;
import com.technical_test.technical_test.models.ProductSalesModel;
import com.technical_test.technical_test.models.ProductStockModel;
import com.technical_test.technical_test.services.ISortService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SortServiceImpl implements ISortService {

    public List<String> sortProducts(Double salesWeight, Double stockWeight, List<ProductSalesModel> productSales,
                                           List<ProductStockModel> productStock){

        // Si no suman 1, lanzar excepción conforme se introdujeron mal los parámetros
        if (salesWeight + stockWeight != 1) {
            throw new IllegalArgumentException("Las ponderaciones deben sumar 1");
        }

        // Lista de productos con su prioridad calculada
        List<ProductModel> productsPriority = new ArrayList<>();

        for (ProductSalesModel sale : productSales) {
            String productId = sale.getProductId();
            double saleAmount = sale.getSales();
            int stockAmount = productStock.stream()
                    .filter(stock -> stock.getProductId().equals(productId))
                    .map(ProductStockModel::getStock)
                    .findFirst()
                    .orElse(0);

            // Calcular la prioridad usando las ponderaciones
            double priority = (saleAmount * salesWeight) + (stockAmount * stockWeight);
            productsPriority.add(new ProductModel(productId, priority));
        }

        // Añadir productos que solo están en la lista de stock
        for (ProductStockModel stock : productStock) {
            String productId = stock.getProductId();
            if (productsPriority.stream().noneMatch(p -> p.getProductId().equals(productId))) {
                double priority = stock.getStock() * stockWeight;
                productsPriority.add(new ProductModel(productId, priority));
            }
        }

        return productsPriority.stream()
                .sorted(Comparator.comparingDouble(ProductModel::getPriority).reversed())
                .map(ProductModel::getProductId)
                .collect(Collectors.toList());
    }
}

