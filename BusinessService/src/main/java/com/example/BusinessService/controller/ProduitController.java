package com.example.BusinessService.controller;

import com.example.BusinessService.model.Produit;
import com.example.BusinessService.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @GetMapping
    public List<Produit> getProduits() {

        return produitService.getProduits();
    }
    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {

        return produitService.createProduit(produit);
    }

    @PutMapping("/{id}")
    public Produit updateProduit(@PathVariable Long id, @RequestBody Produit produit) {
        return produitService.updateProduit(id, produit);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
    }
}
