
package soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import soa.entities.Devise;
import soa.metier.DeviseMetierInterface;

import java.util.List;

@SpringBootApplication
public class SpringJpaApplication2 {

    static DeviseMetierInterface deviseMetier;

    public static void main(String[] args) {
        ApplicationContext contexte = SpringApplication.run(SpringJpaApplication2.class, args);
        deviseMetier = contexte.getBean(DeviseMetierInterface.class);


        // Exemple d'utilisation pour la gestion des devises
        System.out.println("---------Exemple pour la gestion des devises----------");
        ajouterDevisesExemple();
        afficherToutesLesDevises();

        // Appel de la m�thode pour tester la conversion
        testerConversion();
    }

    // M�thode d'exemple pour ajouter quelques devises
    static void ajouterDevisesExemple() {
        deviseMetier.ajouterDevise(new Devise("TND","DT", 1.0, 376.76));
        deviseMetier.ajouterDevise(new Devise("Dirham","DH", 3.24, 6176.0));
        deviseMetier.ajouterDevise(new Devise("SAR","SR", 1.2, 6176.0));
        deviseMetier.ajouterDevise(new Devise("EUR","E", 0.3, 1000.0));
        deviseMetier.ajouterDevise(new Devise("USD","$", 0.32, 2222.0));
        deviseMetier.ajouterDevise(new Devise("YEN","Y", 46.28, 3716.23));
        deviseMetier.ajouterDevise(new Devise("QAR","Q", 1.16, 976.16));
        deviseMetier.ajouterDevise(new Devise("YER","Y", 79.96, 676.40));
        deviseMetier.ajouterDevise(new Devise("WON","W", 420.91, 160.0));
        deviseMetier.ajouterDevise(new Devise("Roupie","R", 26.65, 6176.0));

    }

    // M�thode d'exemple pour afficher toutes les devises
    static void afficherToutesLesDevises() {
        System.out.println("********************D�but**********************");
        System.out.println("Afficher toutes les devises...");
        System.out.println("***********************************************");

        List<Devise> devises = deviseMetier.getAllDevises();
        for (Devise devise : devises) {
            System.out.println(devise);
        }

        System.out.println("********************Fin************************");
    }

    // M�thode d'exemple pour tester la conversion
    // M�thode d'exemple pour tester la conversion
    static void testerConversion() {
        double montant = 100.0;
        System.out.println("Montant a convertir : " + montant);

        String deviseCible = "USD";
        System.out.println("Devise cible : " + deviseCible);

        double montantConverti = deviseMetier.convertirMontant(montant, deviseCible);
        System.out.println("Montant converti en " + deviseCible + ": " + montantConverti);
    }




}
