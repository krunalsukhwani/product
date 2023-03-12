package com.example.walmart.service;

import com.example.walmart.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{

    Map<Integer,Product> productMap = new HashMap<>();

    @Override
    public void saveProductDetails(Product product) throws Exception {
        if(productMap.containsKey(product.getProductId())){
            throw new Exception("This product Id already exists");
        }
        productMap.put(product.getProductId(),product);
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productMap.values();
    }

    @Override
    public void updateProductDetails(Product product) throws Exception {
        if(!productMap.containsKey(product.getProductId())){
            throw new Exception("Product Id doesn't exist");
        }
        productMap.put(product.getProductId(),product);
    }

    @Override
    public void deleteProductDetails(int productId) throws Exception {
        if(!productMap.containsKey(productId)){
            throw new Exception("Product Id doesn't exist");
        }
        productMap.remove(productId);
    }

    @Override
    public Product getSingleProductDetails(int productId) throws Exception {
        if(!productMap.containsKey(productId)){
            throw new Exception("Product Id doesn't exist");
        }
        return productMap.get(productId);
    }
}
