package com.product.productService.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_details")
@Getter
@Setter
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description")
    private String productDescription;

    @ManyToOne
    private Product product;
}
