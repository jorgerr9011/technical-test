package com.technical_test.technical_test.controllers;

import com.technical_test.technical_test.mappers.Mapper;
import com.technical_test.technical_test.models.ProductModel;
import com.technical_test.technical_test.models.ProductSalesModel;
import com.technical_test.technical_test.models.ProductStockModel;
import com.technical_test.technical_test.models.dtos.ProductRequest;
import com.technical_test.technical_test.models.dtos.ProductSalesDto;
import com.technical_test.technical_test.models.dtos.ProductStockDto;
import com.technical_test.technical_test.services.ISortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sort-products")
public class SortController {

    @Autowired
    private ISortService sortService;

    @Autowired
    private Mapper<ProductSalesModel, ProductSalesDto> productSalesMapper;

    @Autowired
    private Mapper<ProductStockModel, ProductStockDto> productStockMapper;

    @PostMapping
    public List<String> sortProducts(@RequestBody ProductRequest productRequest){

        List<ProductSalesModel> productSalesList = productRequest.getProductSales().stream().map(productSalesMapper::mapFrom).toList();
        List<ProductStockModel> productStockList = productRequest.getProductStock().stream().map(productStockMapper::mapFrom).toList();

        return this.sortService.sortProducts(productRequest.getSalesWeight(),
                productRequest.getStockWeight(),
                productSalesList, productStockList);
    }
}
