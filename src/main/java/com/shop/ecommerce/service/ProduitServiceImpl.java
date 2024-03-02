package com.shop.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.ecommerce.modele.Produit;
import com.shop.ecommerce.repository.ProduitRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProduitServiceImpl implements ProduitService {

	private final ProduitRepository produitRepository;

	@Override
	public Produit getProductById(Long idProd) {
		return produitRepository.findById(idProd)
				.orElseThrow(() -> new RuntimeException("Produit non trouvé!"));
	}

	@Override
	public Produit creer(Produit produit) {
		return produitRepository.save(produit);
	}

	@Override
	public List<Produit> lire() {
		return produitRepository.findAll(); 
	}

	@Override
	public Produit modifier(Long idProd, Produit produit) {
		return produitRepository.findById(idProd)
                .map(p -> {
                    p.setProdNom(produit.getProdNom());
                    p.setProdCat(produit.getProdCat());
                    p.setProdDescription(produit.getProdDescription());
                    p.setProdPrix(produit.getProdPrix());
                    p.setProdQnt(produit.getProdQnt());
                    return produitRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Produit non trouvé!"));
    }

	@Override
	public String supprimer(Long idProd) {
		produitRepository.deleteById(idProd);
		return "Produit supprimer avec success!";
	}
	
	@Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

}
