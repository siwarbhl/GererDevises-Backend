package soa.entities;


import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Stock
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50)
    private String code;

    @Column(length = 50)
    private String adresse;

    @ManyToMany (mappedBy = "stocks", cascade = CascadeType.REMOVE)
    private Collection<Produit> produits = new ArrayList<Produit>();

    @OneToOne (cascade= {CascadeType.PERSIST})
    private Client client;

    public String getCode() {
        return code;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Stock(String code, String adresse, Client client) {
        super();
        this.code = code;
        this.adresse = adresse;
        this.client = client;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @JsonIgnore
    public Collection<Produit> getProduits() {
        return produits;
    }
    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }
    @Override
    public String toString() {
        return "Stock [id=" + id + ", code=" + code + ", adresse=" + adresse + "]";
    }
    public Stock() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Stock(String code, String adresse) {
        super();
        this.code = code;
        this.adresse = adresse;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
