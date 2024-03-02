package com.shop.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ecommerce.modele.Panier;

public interface PanierRepository extends JpaRepository<Panier, Long>{
    //int countByUserId(Long idUser); 
    int countByUtilisateur_IdUser(Long userId);
    Optional<Panier> findFirstByUtilisateur_IdUser(Long userId);
}
