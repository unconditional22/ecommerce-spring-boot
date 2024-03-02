package com.shop.ecommerce.service;

import java.util.List;

import com.shop.ecommerce.modele.Paiement;

public interface PaiementService {

    Paiement creer(Paiement paiement);
    
    List<Paiement> lire();
    
    Paiement modifier(Long idPaiement, Paiement paiement);
    
    String supprimer(Long idPaiement);
}

