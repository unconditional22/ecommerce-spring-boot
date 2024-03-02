package com.shop.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.ecommerce.config.CartNotFoundException;
import com.shop.ecommerce.modele.Panier;
import com.shop.ecommerce.modele.Produit;
import com.shop.ecommerce.repository.PanierRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PanierServiceImpl implements PanierService {
    
	private final PanierRepository panierRepository;
	
    
	@Override
    public int getPanierItemCount(Long idUser) {
        return panierRepository.countByUtilisateur_IdUser(idUser);
    }


    // @Override
    // public Panier creer(Panier panier) {
    //     return panierRepository.save(panier);
    // }

    @Override
    public Panier addToCart(Panier panier) {
        // Implement the logic to add the product to the cart
        // You may need to adjust this based on your entity relationships
        return panierRepository.save(panier);
    }

    @Override
    public void addProductToCart(Produit product) {
        // Assuming you have a way to identify the user, replace 1L with the actual user ID
        // You might want to add more logic based on your requirements
        Long idUser = 1L;
        //Long userId = getCurrentUserId(); 


        // Check if the user already has a cart, or create a new one if not
        Panier userCart = panierRepository.findFirstByUtilisateur_IdUser(idUser)
                .orElse(new Panier());

        // Add the product to the cart
        // Assuming you have a method to add a product to the cart, replace it accordingly
        // For example, you might have a Set<Produit> in your Panier entity
        userCart.addProduct(product);

        // Save the updated cart
        panierRepository.save(userCart);
    }
    
    @Override
    public List<Panier> lire() {
        return panierRepository.findAll();
    }

    @Override
    public Panier modifier(Long idPanier, Panier panier) {
        return panierRepository.findById(idPanier)
                .map(pa -> {
                	pa.setPanierQnt(panier.getPanierQnt());
                	pa.setPrixTotalPanier(panier.getPrixTotalPanier());
                	pa.setUtilisateur(panier.getUtilisateur());
                	//pa.setProduits(panier.getProduits());
                    return panierRepository.save(pa);
                })
                //.orElseThrow(() -> new RuntimeException("Panier non trouvé!"));
                .orElseThrow(() -> new CartNotFoundException("Panier non trouvé pour id: " + idPanier));
    }

    @Override
    public String supprimer(Long idPanier) {
        panierRepository.deleteById(idPanier);
        return "Panier supprimé avec succès!";
    }


}
