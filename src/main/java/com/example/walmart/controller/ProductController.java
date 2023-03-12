package com.example.walmart.controller;

import com.example.walmart.model.Product;
import com.example.walmart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("")
    public String home(){
        return "Product Management System";
    }

    @PostMapping(value = "/product/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void saveProductDetails(@RequestBody Product product) throws Exception {
        productService.saveProductDetails(product);
    }

    @RequestMapping(value = "/product/all", method = RequestMethod.GET)
    public Iterable<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/product/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateProductDetails(@RequestBody Product product) throws Exception {
        productService.updateProductDetails(product);
    }

    @RequestMapping(value = "/product/delete", method = RequestMethod.DELETE)
    public void deleteProductDetails(@RequestParam("productId") int productId) throws Exception {
        productService.deleteProductDetails(productId);
    }

    @GetMapping(value = "/product/single/{productId}")
    public Product getSingleProductDetails(@PathVariable("productId") int productId) throws Exception{
        return productService.getSingleProductDetails(productId);
    }
}
