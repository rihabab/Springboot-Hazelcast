package com.example.demo.controllers;


import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j
@CacheConfig(cacheNames = "product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    @Cacheable(value = "productsCache")
    public List<Product> getAllProducts() {
        log.info("fetching all");
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id")
    public Product getProductById(@PathVariable int id) {
        log.info("fetching the product for the first time with " + id + "from DB");
        return productService.getProductById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}