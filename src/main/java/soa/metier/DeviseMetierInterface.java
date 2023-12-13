package soa.metier;

import soa.entities.Devise;

import java.util.List;

public interface DeviseMetierInterface {
    List<Devise> getAllDevises();
    Devise getDeviseById(Long id);
    Devise ajouterDevise(Devise devise);
    void supprimerDevise(Long id);
    Devise updateDevise(Long id,  double nouveauTaux);
    Devise getDeviseByCode(String code);
    double convertirMontant(double montant, String deviseCible);

}
