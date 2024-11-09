package com.product.productService.dto;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface IProductDto{
    Long getId();
    String getProductName();
//    @Value("#{@productDetailsMapper.mapToDto(target.productDetails)}")
    List<IProductDetailsDto> getProductDetails();
}
