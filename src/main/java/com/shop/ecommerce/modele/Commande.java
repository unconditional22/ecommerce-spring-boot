package com.shop.ecommerce.modele;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "commande")
@Getter 
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "idUser")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCom") 
    private Long idCom;
	
	@Column(length = 10)
	private Date cmdDate;
	
	@Column(length = 15)
	private float cmdMnt;

    @ManyToOne
    @JoinColumn(name = "idUser") 
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "commande") 
    private List<Produit> produits;

    @OneToMany(mappedBy = "commande")
    private List<CommandeDetaille> commandeDetails;

    @OneToOne(mappedBy = "commande")
    private Paiement paiement;
}