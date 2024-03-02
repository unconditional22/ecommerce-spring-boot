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

import com.shop.ecommerce.modele.Commande;
import com.shop.ecommerce.service.CommandeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/commande")
@AllArgsConstructor
public class CommandeController {
	
	private final CommandeService commandeService;
	
	@PostMapping("/create")
	public Commande create(@RequestBody Commande commande) {
		return commandeService.creer(commande); 
	}
	
	@GetMapping("/read")
	public List<Commande> read() {
		return commandeService.lire();
	}
	
	@PutMapping("/update/{idCom}")
	public Commande update(@PathVariable Long idCom, @RequestBody Commande commande) {
		return commandeService.modifier(idCom, commande);
	}
	
	@DeleteMapping("/delete/{idCom}")
	public String delete(@PathVariable Long idCom) {
		return commandeService.supprimer(idCom);
	}
}
