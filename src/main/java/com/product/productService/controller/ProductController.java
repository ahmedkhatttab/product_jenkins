package com.product.productService.controller;

import com.product.productService.dto.IProductDto;
import com.product.productService.dto.ProductDto;
import com.product.productService.entity.Product;
import com.product.productService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductInfoById(@PathVariable long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }


    @GetMapping("/jpql/dto")
    public ResponseEntity<List<IProductDto>> getAllProductsD(){
        return ResponseEntity.ok(productService.getAllProductsJpqlD());
    }

//    @GetMapping("/jpql/i")
//    public ResponseEntity<List<IProductDto>> getAllProductsI(){
//        return ResponseEntity.ok(productService.getAllProductsJpqlI());
//    }
//
//
//    @GetMapping("/native/dto")
//    public ResponseEntity<List<ProductDto>> getAllProductsNativeD(){}
//
//    @GetMapping("/native/i")
//    public ResponseEntity<List<IProductDto>> getAllProductsNativeI(){
//        return ResponseEntity.ok(productService.getAllProductsNativeI());
//    }
}
