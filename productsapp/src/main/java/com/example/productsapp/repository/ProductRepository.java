package com.example.productsapp.repository;

import com.example.productsapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {
    Product findByProductName(String productName);
}
