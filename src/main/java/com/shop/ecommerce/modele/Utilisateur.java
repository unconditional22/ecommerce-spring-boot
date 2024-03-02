package com.shop.ecommerce.modele;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;

@Entity
@Table(name = "utilisateur")
@Getter 
@Setter
@NoArgsConstructor
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUser") 
    private Long idUser;
	
	@Column(length = 50)
	private String username;
	
	@Column(length = 45)
	private String password;
	
	@Column(length = 80)
	private String email;
	
	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Commande> commandes = new ArrayList<>();

    @OneToMany(mappedBy = "utilisateur")
    private List<Panier> paniers;
}
