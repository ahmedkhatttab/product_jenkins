package com.product.productService.dto;

import com.product.productService.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
public class ProductDto {
    private Long id;
    private String productName;
    private List<ProductDetailsDto> productDetails;

    public ProductDto(Long id, String productName){
        this.id = id;
        this.productName = productName;
        this.productDetails = productDetails;
    }

}
