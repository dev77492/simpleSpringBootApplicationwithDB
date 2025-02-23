package com.dev77492WebApp.demoWebApp.controllers;

import com.dev77492WebApp.demoWebApp.model.Product;
import com.dev77492WebApp.demoWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService service;
    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/products/id=={prodId}")
    public Product getProductById(@PathVariable int prodId){
        return service.getProductById(prodId);

    }
    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod){
        service.addProduct(prod);

    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod){
        service.updateProduct(prod);
    }

    @DeleteMapping("/products")
    public void deleteProduct(@RequestBody Product prod){
        service.deleteProduct(prod);
    }

    @DeleteMapping("/products/id=={prodId}")
    public void deleteProductById(@PathVariable int prodId){
        service.deleteProductById(prodId);
    }
}
