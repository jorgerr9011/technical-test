package com.technical_test.technical_test.mappers.impl;

import com.technical_test.technical_test.mappers.Mapper;
import com.technical_test.technical_test.models.ProductSalesModel;
import com.technical_test.technical_test.models.ProductStockModel;
import com.technical_test.technical_test.models.dtos.ProductSalesDto;
import com.technical_test.technical_test.models.dtos.ProductStockDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductStockMapper implements Mapper<ProductStockModel, ProductStockDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductStockDto mapTo(ProductStockModel productStockModel) {
        return modelMapper.map(productStockModel, ProductStockDto.class);
    }

    @Override
    public ProductStockModel mapFrom(ProductStockDto productStockDto) {
        return modelMapper.map(productStockDto, ProductStockModel.class);
    }
}
