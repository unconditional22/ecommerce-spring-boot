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
@Table(name = "detaille")
@Getter 
@Setter
@NoArgsConstructor
public class CommandeDetaille {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDetail") 
    private Long idDetail;
	
	private int detailQnt;
	private BigDecimal detailPrix;

    @ManyToOne
    @JoinColumn(name = "idCom")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "idProd")
    private Produit produit;
}
