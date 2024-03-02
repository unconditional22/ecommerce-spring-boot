package com.shop.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.ecommerce.modele.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{

}
