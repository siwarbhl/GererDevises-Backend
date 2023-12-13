package soa.entities;

import jakarta.persistence.*;


@Entity
public class FactureDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Facture facture;
    @ManyToOne
    private Produit produit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public FactureDetail(Long id, Facture facture, Produit produit) {
        this.id = id;
        this.facture = facture;
        this.produit = produit;
    }
}
