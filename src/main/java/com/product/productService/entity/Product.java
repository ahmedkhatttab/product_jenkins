package com.product.productService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "price")
    private long price;
    @Column(name = "quantity")
    private int quantity;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.ALL})
    List<ProductDetails> productDetails = new ArrayList<>();
}
