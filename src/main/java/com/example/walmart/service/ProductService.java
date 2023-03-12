package com.example.walmart.service;

import com.example.walmart.model.Product;

public interface ProductService {

    void saveProductDetails(Product product) throws Exception;

    Iterable<Product> getAllProducts();

    void updateProductDetails(Product product) throws Exception;

    void deleteProductDetails(int productId) throws Exception;

    Product getSingleProductDetails(int productId) throws Exception;
}
