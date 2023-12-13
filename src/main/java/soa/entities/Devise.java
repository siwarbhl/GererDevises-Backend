package soa.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "devise")
public class Devise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String symbole;
    private double taux;
    private double montant;

    public Devise() {
    }

    public Devise(String code, String symbole, double taux, double montant) {
        this.id = id;
        this.code = code;
        this.symbole =  symbole;
        this.taux = taux;
        this.montant = montant;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Devise{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", symbole='" + symbole + '\'' +
                ", taux=" + taux +
                ", montant=" + montant +
                '}';
    }

    // Méthode pour convertir un montant vers une autre devise

    public Double convertirMontant(Devise autreDevise, Double montantAConvertir) {
        if (taux != 0 && autreDevise.getTaux() != 0) {
            return montantAConvertir * (autreDevise.getTaux() / taux);
        } else {
            throw new IllegalStateException("Les taux de change ne sont pas définis pour les devises.");
        }
    }

}



