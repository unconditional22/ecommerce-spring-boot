package com.shop.ecommerce.modele;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "panier")
@Getter
@Setter
@NoArgsConstructor
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPanier")
    private Long idPanier;
    
    private int panierQnt;
    private BigDecimal prixTotalPanier;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Utilisateur utilisateur;

    // Add this Set to store the products in the cart
    @ManyToMany
    @JoinTable(
        name = "panier_produit",
        joinColumns = @JoinColumn(name = "idPanier"),
        inverseJoinColumns = @JoinColumn(name = "idProd"))
    private Set<Produit> produits = new HashSet<>();

    // Method to add a product to the cart
    public void addProduct(Produit product) {
        this.produits.add(product);
    }
    
//    @OneToMany(mappedBy = "panier")
//    private List<Produit> produits;
    
//    @ManyToMany
//    @JoinTable(
//        name = "panier_produit",
//        joinColumns = @JoinColumn(name = "idPanier"),
//        inverseJoinColumns = @JoinColumn(name = "idProd")
//    )
//    private List<Produit> produits;

}