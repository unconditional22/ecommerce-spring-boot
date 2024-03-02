package com.shop.ecommerce.service;

import java.util.List;

import com.shop.ecommerce.dto.UtilisateurDto;
import com.shop.ecommerce.modele.Utilisateur;

public interface UtilisateurService {
	Utilisateur creer(Utilisateur utilisateur);
	
	List<Utilisateur> lire();
	
	Utilisateur modifier(Long idUser, Utilisateur utilisateur);
	
	String supprimer(Long idUser);
	
	
	void saveUser(UtilisateurDto utilisateurdto);

	Utilisateur findUserByEmail(String email);

    List<UtilisateurDto> findAllUsers();
}
