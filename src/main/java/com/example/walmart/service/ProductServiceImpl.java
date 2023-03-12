package com.example.walmart.service;

import com.example.walmart.model.Product;
import com.example.walmart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public void saveProductDetails(Product product) throws Exception {
        if(productRepository.existsById(product.getProductId())){
            throw new Exception("This product Id already exists");
        }
        productRepository.save(product);
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void updateProductDetails(Product product) throws Exception {
        if(!productRepository.existsById(product.getProductId())){
            throw new Exception("Product Id doesn't exist");
        }
        productRepository.save(product);
    }

    @Override
    public void deleteProductDetails(int productId) throws Exception {
        if(!productRepository.existsById(productId)){
            throw new Exception("Product Id doesn't exist");
        }
        productRepository.deleteById(productId);
    }

    @Override
    public Optional<Product> getSingleProductDetails(int productId) throws Exception {
        if(!productRepository.existsById(productId)){
            throw new Exception("Product Id doesn't exist");
        }
        return productRepository.findById(productId);
    }
}
