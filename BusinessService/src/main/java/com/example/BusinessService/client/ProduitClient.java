package com.example.BusinessService.client;

import com.example.BusinessService.model.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "demo", url = "http://localhost:8080")
public interface ProduitClient {
    @GetMapping("/products")
    List<Produit> getProduits();

    @GetMapping("/products/{id}")
    Produit getProduit(@PathVariable("id") int id);

    @PostMapping("/products")
    Produit createProduit(@RequestBody Produit produit);

    @PutMapping("/products/{id}")
    Produit updateProduit(@PathVariable("id") Long id, @RequestBody Produit produit);

    @DeleteMapping("/products/{id}")
    void deleteProduit(@PathVariable("id") Long id);
}
