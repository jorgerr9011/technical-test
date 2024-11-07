package com.technical_test.technical_test.services;

import com.technical_test.technical_test.models.ProductModel;
import com.technical_test.technical_test.models.ProductSalesModel;
import com.technical_test.technical_test.models.ProductStockModel;

import java.util.List;

public interface ISortService {

    List<String> sortProducts(Double salesWeight, Double stockWeight, List<ProductSalesModel> productSales,
                                    List<ProductStockModel> productStock);
}
