package com.shop.ecommerce.service;

import java.util.List;

import com.shop.ecommerce.modele.Panier;
import com.shop.ecommerce.modele.Produit;

public interface PanierService {
	
    int getPanierItemCount(Long idUser); 
	
	// Panier creer(Panier panier);

    Panier addToCart(Panier panier);

	void addProductToCart(Produit product); 
	
	List<Panier> lire();
	
	Panier modifier(Long idPanier, Panier panier);
	
	String supprimer(Long idPanier);

}
