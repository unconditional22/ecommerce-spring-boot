package com.shop.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ecommerce.modele.CommandeDetaille;

public interface CommandeDetailleRepository extends JpaRepository<CommandeDetaille, Long>{
	
}
