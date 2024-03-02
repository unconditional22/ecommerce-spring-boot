package com.shop.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shop.ecommerce.modele.CommandeDetaille;
import com.shop.ecommerce.modele.Paiement;
import com.shop.ecommerce.modele.Produit;
import com.shop.ecommerce.repository.PaiementRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaiementServiceImpl implements PaiementService {

    private final PaiementRepository paiementRepository;

    @Override
    public Paiement creer(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public List<Paiement> lire() {
        return paiementRepository.findAll();
    }
    
    public Paiement modifier(Long idPaiement, Paiement paiement) {
		return paiementRepository.findById(idPaiement)
		        .map(p -> {
		        	p.setMntPaiement(paiement.getMntPaiement());
		            p.setDatePaiement(paiement.getDatePaiement());
		            p.setModePaiement(paiement.getModePaiement());
		            p.setStatutPaiement(paiement.getStatutPaiement());
		            p.setCommande(paiement.getCommande());
		            return paiementRepository.save(p);
		        }).orElseThrow(() -> new RuntimeException("Paiement non trouvé!"));
	}

    @Override
    public String supprimer(Long idPaiement) {
        paiementRepository.deleteById(idPaiement);
        return "Paiement supprimé avec succès!";
    }

    // @Override
    // public Paiement getPaiementById(Long idPaiement) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getPaiementById'");
    // }
}
