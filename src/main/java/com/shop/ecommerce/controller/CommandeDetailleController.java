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

import com.shop.ecommerce.modele.CommandeDetaille;
import com.shop.ecommerce.service.CommandeDetailleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/detaille")
@AllArgsConstructor
public class CommandeDetailleController {
	
	private final CommandeDetailleService commandeDetailleService;
	
	@PostMapping("/create")
	public CommandeDetaille create(@RequestBody CommandeDetaille detaille) {
		return commandeDetailleService.creer(detaille); 
	}
	
	@GetMapping("/read")
	public List<CommandeDetaille> read() {
		return commandeDetailleService.lire();
	}
	
	@PutMapping("/update/{idDetail}")
	public CommandeDetaille update(@PathVariable Long idDetail, @RequestBody CommandeDetaille detaille) {
		return commandeDetailleService.modifier(idDetail, detaille);
	}
	
	@DeleteMapping("/delete/{idDetail}")
	public String delete(@PathVariable Long idDetail) {
		return commandeDetailleService.supprimer(idDetail);
	}
}
