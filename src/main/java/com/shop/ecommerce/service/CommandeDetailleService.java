package com.shop.ecommerce.service;

import java.util.List;

import com.shop.ecommerce.modele.CommandeDetaille;

public interface CommandeDetailleService {
	CommandeDetaille creer(CommandeDetaille detaille);
	
	List<CommandeDetaille> lire();
	
	CommandeDetaille modifier(Long idDetail, CommandeDetaille detaille);
	
	String supprimer(Long idDetail);
}
