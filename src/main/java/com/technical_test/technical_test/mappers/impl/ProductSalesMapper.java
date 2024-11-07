package com.technical_test.technical_test.mappers.impl;

import com.technical_test.technical_test.mappers.Mapper;
import com.technical_test.technical_test.models.ProductSalesModel;
import com.technical_test.technical_test.models.dtos.ProductSalesDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductSalesMapper implements Mapper<ProductSalesModel, ProductSalesDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductSalesDto mapTo(ProductSalesModel productSalesModel) {
        return modelMapper.map(productSalesModel, ProductSalesDto.class);
    }

    @Override
    public ProductSalesModel mapFrom(ProductSalesDto productSalesDto) {
        return modelMapper.map(productSalesDto, ProductSalesModel.class);
    }
}
