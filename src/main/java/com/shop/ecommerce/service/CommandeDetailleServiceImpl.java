package com.shop.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.ecommerce.modele.CommandeDetaille;
import com.shop.ecommerce.repository.CommandeDetailleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommandeDetailleServiceImpl implements CommandeDetailleService{
	
	private final CommandeDetailleRepository commandeDetailleRepository;
	
	@Override
	public CommandeDetaille creer(CommandeDetaille detaille) {
			return commandeDetailleRepository.save(detaille);
	}

	@Override
	public List<CommandeDetaille> lire() {
		return commandeDetailleRepository.findAll();
	}

	@Override
	public CommandeDetaille modifier(Long idDetail, CommandeDetaille detaille) {
		return commandeDetailleRepository.findById(idDetail)
		        .map(d -> {
		            d.setDetailQnt(detaille.getDetailQnt());
		            d.setDetailPrix(detaille.getDetailPrix());
		            d.getCommande().setIdCom(detaille.getCommande().getIdCom());
	                d.getProduit().setIdProd(detaille.getProduit().getIdProd());
		            return commandeDetailleRepository.save(d);
		        }).orElseThrow(() -> new RuntimeException("Commande Detaille non trouvé!"));
	}

	@Override
	public String supprimer(Long idDetail) {
		commandeDetailleRepository.deleteById(idDetail);
		return "Commande Detaille supprimer avec success!";
	}
}
