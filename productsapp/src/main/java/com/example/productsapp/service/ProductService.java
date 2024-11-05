package com.example.productsapp.service;

import com.example.productsapp.entity.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getProducts();

    Product getProduct(Long productId);

    Product updateProduct(Long productId, Product product);

    Product getProductByName(String productName);

    void deleteProduct(Long productId);
}
