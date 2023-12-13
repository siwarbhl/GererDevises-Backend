package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soa.entities.Devise;
import soa.entities.Produit;
import soa.metier.DeviseMetierImpl;
import soa.repository.DeviseRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/devises")
public class DeviseRESTController {

    @Autowired
    private DeviseRepository deviseRepository;
    @Autowired
    private DeviseMetierImpl deviseMetier;


    @GetMapping(value = "/index")
    public String accueil() {
        return "Bienvenue au service Web REST 'devises'.....";
    }

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Devise> getAllDevises() {
        return deviseRepository.findAll();
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Devise> getDevise(@PathVariable Long id) {
        Devise devise = deviseRepository.findById(id).orElse(null);
        if (devise != null) {
            return ResponseEntity.ok(devise);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Devise saveDevise(@RequestBody Devise devise) {
        return deviseRepository.save(devise);
    }



    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Devise> updateDevise(@PathVariable Long id, @RequestBody Devise updatedDevise) {
        Devise existingDevise = deviseRepository.findById(id).orElse(null);

        if (existingDevise != null) {
            // Update the properties of the existing Devise with those of the updated Devise
            existingDevise.setCode(updatedDevise.getCode());
            existingDevise.setSymbole(updatedDevise.getSymbole());
            existingDevise.setTaux(updatedDevise.getTaux());
            existingDevise.setMontant(updatedDevise.getMontant());

            // Save the updated Devise in the repository
            Devise savedDevise = deviseRepository.save(existingDevise);
            return ResponseEntity.ok(savedDevise);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    // Supprimer un devise par 'id' avec la méthode 'GET'
    // http://localhost:8080/produits/delete/{id} (GET)
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDevise(@PathVariable Long id) {
        if (deviseRepository.existsById(id)) {
            deviseRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un devise avec la méthode 'DELETE'
    // http://localhost:8080/produits/ (DELETE)
    @DeleteMapping(value = "/")
    public void deleteDevise(@RequestBody Devise d) {
        deviseRepository.delete(d);
    }

    @GetMapping(value = "/convertirMontant", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> convertirMontant(
            @RequestParam("montant") double montant,
            @RequestParam("deviseCible") String deviseCible) {
        try {
            double convertedAmount = deviseMetier.convertirMontant(montant, deviseCible);
            return ResponseEntity.ok(convertedAmount);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build(); // or handle the exception based on your requirements
        }
    }



}
