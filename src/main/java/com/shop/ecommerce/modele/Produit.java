package com.shop.ecommerce.modele;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produit")
@Getter 
@Setter
@NoArgsConstructor

public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProd") 
    private Long idProd;
	
	@Column(length = 50)	
	private String prodNom;
	
	@Column(length = 150)	
	private String prodCat;
	private String prodDescription;
	
	private BigDecimal prodPrix;
	private int prodQnt;
	
	@ManyToOne
    @JoinColumn(name = "idCom")
    private Commande commande;

//    @ManyToMany(mappedBy = "produits")
//    private List<Panier> paniers;
    
//    @ManyToOne
//    @JoinColumn(name = "idPanier")
//    private Panier panier;
}

