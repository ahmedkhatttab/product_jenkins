package com.product.productService.repository;

import com.product.productService.dto.IProductDto;
import com.product.productService.dto.ProductDto;
import com.product.productService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {



//    @Query("select new com.product.productService.dto.ProductDto(p.Id, p.productName) from Product p")
//    @Query(value = "select p.id, p.product_name from product p", nativeQuery = true)

//    @Query("select p.Id as id, p.productName as productName, p.productDetails as productDetails from Product p")
//    List<IProductDto> getAllProductJpqlD();

    @Query(
    value = "select p.id as id, p.product_name as productName, pd.id, pd.description from " +
            "product p " +
            "inner join product_details pd on p.id = pd.product_id",
        nativeQuery = true
    )
    List<IProductDto> getAllProductJpqlD();

    // works in case of collection
//    @Query("select p.Id as id, p.productName as productName, p.productDetails as productDetails from Product p")
//    List<IProductDto> getAllProductJpqlI();

//    @Query(
//        value = "select p.id as id, p.product_name as productName, pd.description as productDetails from " +
//                "product p " +
//                "inner join product_details pd on p.id = pd.product_id",
//            nativeQuery = true
//    )
//    List<IProductDto> getAllProductNativeI();


//    List<ProductDto> getAllProductNativeD();
}
