package com.product.productService.dto;

import lombok.Data;

@Data
public class ProductDetailsDto {
    private Long id;
    private String productDescription;

    public ProductDetailsDto(Long id, String productDescription){
        this.id = id;
        this.productDescription = productDescription;
    }
}
