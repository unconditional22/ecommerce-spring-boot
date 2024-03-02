package com.shop.ecommerce.service;

import java.util.List;

import com.shop.ecommerce.modele.Produit;

public interface ProduitService {

	Produit getProductById(Long idProd);
	
	Produit creer(Produit produit);
	
	List<Produit> lire();
	
	Produit modifier(Long idProd, Produit produit);
	
	String supprimer(Long idProd);
	
	List<Produit> getAllProduits();
}
