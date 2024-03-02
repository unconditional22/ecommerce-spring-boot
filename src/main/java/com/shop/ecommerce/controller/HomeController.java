package com.shop.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shop.ecommerce.modele.Paiement;
import com.shop.ecommerce.modele.Produit;
import com.shop.ecommerce.service.PaiementService;
import com.shop.ecommerce.service.ProduitService;

@Controller
public class HomeController {
    
    private final ProduitService produitService;

    @Autowired
    public HomeController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        List<Produit> clothProducts = produitService.getAllProduits();
        model.addAttribute("clothProducts", clothProducts);
        return "home";
    }

    @GetMapping("/produit-details/{idProd}")
    public String productDetailsPage(@PathVariable Long productId, Model model) {
        Produit product = produitService.getProductById(productId);
        model.addAttribute("product", product);
        return "produit-details";
    }

    @GetMapping("/paiement")
    public String paiementPage() {
        return "paiement";
    }

}

