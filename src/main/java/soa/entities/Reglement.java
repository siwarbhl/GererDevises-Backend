package soa.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


@Entity
public class Reglement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal montant;
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToMany
    private Collection<Facture> facturesDetail = new ArrayList<Facture>();
    @ManyToMany
    private Collection<Devise> devises = new ArrayList<Devise>();

    public Reglement(Long id, BigDecimal montant, Date date, Collection<Facture> facturesDetail) {
        this.id = id;
        this.montant = montant;
        this.date = date;
        this.facturesDetail = facturesDetail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Collection<Facture> getFacturesDetail() {
        return facturesDetail;
    }

    public void setFacturesDetail(Collection<Facture> facturesDetail) {
        this.facturesDetail = facturesDetail;
    }

    @Override
    public String toString() {
        return "Reglement{" +
                "id=" + id +
                ", montant=" + montant +
                ", date=" + date +
                ", facturesDetail=" + facturesDetail +
                '}';
    }
}
