package com.product.productService.service;

import com.product.productService.dto.IProductDto;
import com.product.productService.dto.ProductDto;
import com.product.productService.entity.Product;
import com.product.productService.exception.ProductNotFoundException;
import com.product.productService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Long createProduct(Product product){
        productRepository.save(product);
        return product.getId();
    }

    public Product getProductById(long id){
        return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product Not Found"));
    }

    public List<IProductDto> getAllProductsJpqlD(){
        return productRepository.getAllProductJpqlD();
//        return null;
    }

    public List<IProductDto> getAllProductsJpqlI(){
//        return productRepository.getAllProductJpqlI();
        return null;
    }

    public List<IProductDto> getAllProductsNativeI(){
//        return productRepository.getAllProductNativeI();
        return null;
    }
//    public List<ProductDto> getAllProductsNativeD(){
//
//    }


}
