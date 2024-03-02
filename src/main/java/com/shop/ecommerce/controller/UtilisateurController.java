package com.shop.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.ecommerce.modele.Utilisateur;
import com.shop.ecommerce.service.UtilisateurService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/utilisateur")
@AllArgsConstructor
public class UtilisateurController {
	
	private final UtilisateurService utilisateurService;
	
	@PostMapping("/create")
	public Utilisateur create(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.creer(utilisateur); 
	}
	
	@GetMapping("/read")
	public List<Utilisateur> read() {
		return utilisateurService.lire();
	}
	
	@PutMapping("/update/{idUser}")
	public Utilisateur update(@PathVariable Long idUser, @RequestBody Utilisateur utilisateur) {
		return utilisateurService.modifier(idUser, utilisateur);
	}
	
	@DeleteMapping("/delete/{idUser}")
	public String delete(@PathVariable Long idUser) {
		return utilisateurService.supprimer(idUser);
	}
}
