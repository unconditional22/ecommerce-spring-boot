package com.shop.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ecommerce.modele.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	
	Utilisateur findByEmail(String email);

}
