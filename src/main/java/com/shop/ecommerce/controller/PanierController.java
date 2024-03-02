package com.shop.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.ecommerce.modele.Panier;
import com.shop.ecommerce.modele.Produit;
import com.shop.ecommerce.service.PanierService;
import com.shop.ecommerce.service.ProduitService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/panier")
@AllArgsConstructor
public class PanierController {
	
	@Autowired
    private final PanierService panierService;

    @Autowired
    private final ProduitService produitService;

    @PostMapping("/add")
    public String addToPanier(@RequestParam Long idProd) {
        // Assuming you have a method to get the product details by ID
        Produit product = produitService.getProductById(idProd);

        // Now, you can add the product to the cart or handle it as needed
        // For simplicity, let's assume you have a service method to add a product to the cart
        panierService.addProductToCart(product);

        // Redirect back to the product details page or any other page as needed
        return "redirect:/produit/produit-details/" + idProd;

        //return "redirect:/process-paiement?idProd=" + idProd;
    }
    
    @GetMapping("/count/{idUser}")
    public int getPanierItemCount(@PathVariable Long idUser) {
        return panierService.getPanierItemCount(idUser);
    }

    @PostMapping("/create")
    public Panier create(@RequestBody Panier panier) {
        return panierService.addToCart(panier);
    }

    @GetMapping("/read")
    public List<Panier> read() {
        return panierService.lire();
    }

    @PutMapping("/update/{idPanier}")
    public Panier update(@PathVariable Long idPanier, @RequestBody Panier panier) {
        return panierService.modifier(idPanier, panier);
    }

    @DeleteMapping("/delete/{idPanier}")
    public String delete(@PathVariable Long idPanier) {
        return panierService.supprimer(idPanier);
    }
}
