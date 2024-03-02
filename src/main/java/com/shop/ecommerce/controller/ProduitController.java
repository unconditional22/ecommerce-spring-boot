package com.shop.ecommerce.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.ecommerce.modele.Produit;
import com.shop.ecommerce.service.ProduitService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/produit")
@AllArgsConstructor
public class ProduitController {
	
	private final ProduitService produitService;

	@GetMapping("/produit-details/{idProd}")
	public String productDetailsPage(@PathVariable Long idProd, Model model) {
		Produit product = produitService.getProductById(idProd);
		model.addAttribute("product", product);
		return "produit-details";
	}
	
	@PostMapping("/create")
	public Produit create(@RequestBody Produit produit) {
		return produitService.creer(produit); 
	}
	
	@GetMapping("/read")
	public List<Produit> read() {
		return produitService.lire();
	}
	
	@PutMapping("/update/{idProd}")
	public Produit update(@PathVariable Long idProd, @RequestBody Produit produit) {
		return produitService.modifier(idProd, produit);
	}
	
	@DeleteMapping("/delete/{idProd}")
	public String delete(@PathVariable Long idProd) {
		return produitService.supprimer(idProd);
	}
}
