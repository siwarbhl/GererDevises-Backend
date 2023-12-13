package soa.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numFacture;
    private BigDecimal montant;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    private Devise devise;
    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL)
    private Collection<FactureDetail> facturesDetail = new ArrayList<FactureDetail>();
    @ManyToMany
    private Collection<Reglement> reglements = new ArrayList<Reglement>();


    public Facture(Long id, String numFacture, BigDecimal montant, Devise devise) {
        this.id = id;
        this.numFacture = numFacture;
        this.montant = montant;
        this.devise = devise;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(String numFacture) {
        this.numFacture = numFacture;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", numFacture='" + numFacture + '\'' +
                ", montant=" + montant +
                ", date=" + date +
                ", Client=" + client +
                ", devise=" + devise +
                ", facturesDetail=" + facturesDetail +
                ", reglements=" + reglements +
                '}';
    }
}
