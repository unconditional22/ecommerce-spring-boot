package com.shop.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.ecommerce.modele.Commande;
import com.shop.ecommerce.repository.CommandeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommandeServiceImpl implements CommandeService{
	
	private final CommandeRepository commandeRepository;

	@Override
	public Commande creer(Commande commande) {
			return commandeRepository.save(commande);
	}

	@Override
	public List<Commande> lire() {
		return commandeRepository.findAll();
	}

	@Override
	public Commande modifier(Long idCom, Commande commande) {
		return commandeRepository.findById(idCom)
		        .map(c -> {
		            c.setCmdDate(commande.getCmdDate());
		            c.setCmdMnt(commande.getCmdMnt());
		            return commandeRepository.save(c);
		        }).orElseThrow(() -> new RuntimeException("Commande non trouvé!"));
	}

	@Override
	public String supprimer(Long idCom) {
		commandeRepository.deleteById(idCom);
		return "Commande supprimer avec success!";
	}
	
}
