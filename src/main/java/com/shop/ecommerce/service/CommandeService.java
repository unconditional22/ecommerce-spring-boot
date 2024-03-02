package com.shop.ecommerce.service;

import java.util.List;

import com.shop.ecommerce.modele.Commande;

public interface CommandeService {
	Commande creer(Commande commande);
	
	List<Commande> lire();
	
	Commande modifier(Long idCom, Commande commande);
	
	String supprimer(Long idCom);
}
