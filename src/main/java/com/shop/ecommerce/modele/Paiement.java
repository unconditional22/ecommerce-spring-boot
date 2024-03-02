package com.shop.ecommerce.modele;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "paiement")
@Getter
@Setter
@NoArgsConstructor
public class Paiement {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPaiement")
    private Long idPaiement;
	
	@Column(length = 50)
    private BigDecimal mntPaiement;
	
	@Column(length = 50)
    private Date datePaiement;
	
	@Column(length = 30)
    private String modePaiement;
	
	@Column(length = 30)
    private String statutPaiement;
    
	@OneToOne
    @JoinColumn(name = "idCom")
    private Commande commande;
}
