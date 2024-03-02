package com.shop.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ecommerce.modele.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
