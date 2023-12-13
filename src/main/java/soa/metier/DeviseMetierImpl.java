package soa.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soa.entities.Devise;
import soa.repository.DeviseRepository;

import java.util.List;

@Service
public class DeviseMetierImpl implements DeviseMetierInterface{

    @Autowired
    private DeviseRepository deviseRepository;


    public Devise ajouterDevise(Devise devise) {
        return deviseRepository.save(devise);
    }

    public List<Devise> getAllDevises() {
        return deviseRepository.findAll();
    }

    public Devise getDeviseById(Long id) {
        return deviseRepository.findById(id).orElse(null);
    }

    public void supprimerDevise(Long id) {
        deviseRepository.deleteById(id);
    }
    @Override
    public Devise updateDevise(Long id,  double nouveauTaux) {
        Devise devise = deviseRepository.findById(id).orElse(null);
        if (devise != null) {
            devise.setTaux(nouveauTaux);
            return deviseRepository.save(devise);
        } else {
            // Handle the case when the specified Devise does not exist
            return null;
        }
    }

    @Override
    public Devise getDeviseByCode(String code) {
        return deviseRepository.findByCode(code);
    }

    @Override
    public double convertirMontant(double montant, String deviseCible) {
        Devise deviseCibleObjet = getDeviseByCode(deviseCible);

        if (deviseCibleObjet != null) {
            double tauxEchangeCible = deviseCibleObjet.getTaux();

            // Convertir le montant en euros
            return montant * tauxEchangeCible;
        } else {
            // Gérer le cas où la devise cible n'est pas trouvée
            throw new RuntimeException("Devise cible non trouvée");
        }
    }


}
