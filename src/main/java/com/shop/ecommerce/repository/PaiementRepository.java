package com.shop.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ecommerce.modele.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long>{

}
