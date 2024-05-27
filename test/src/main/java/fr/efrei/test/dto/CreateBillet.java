package fr.efrei.test.dto;
import fr.efrei.test.model.Boutique;
import fr.efrei.test.model.Commande;
import fr.efrei.test.model.Epreuve;
import fr.efrei.test.model.Spectateur;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateBillet {
    
    @NotBlank
    private String uuid;
    
    @NotBlank(message = "Veuillez saisir un nom")
    @Size(min = 2, message = "Le nom doit contenir minimun 2 caractères")
    private String nom;

    @NotBlank(message = "Veuillez saisir un prix")
    private Float prix;
   
    private boolean isValid = false;
    
    @NotBlank(message = "Veuillez saisir une boutique")
    private Boutique boutique;

    @NotBlank(message = "Veuillez saisir une commande")
    private Commande commande;

    @NotBlank(message = "Veuillez saisir une epreuve")
    private Epreuve epreuve;

    @NotBlank(message = "Veuillez saisir un spectateur")
    private Spectateur spectateur;


    /**
     * @return String return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @return String return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return Float return the prix
     */
    public Float getPrix() {
        return prix;
    }

    /**
     * @return boolean return the isValid
     */
    public boolean isIsValid() {
        return isValid;
    }

    /**
     * @return Boutique return the boutique
     */
    public Boutique getBoutique() {
        return boutique;
    }

    /**
     * @return Commande return the commande
     */
    public Commande getCommande() {
        return commande;
    }


    /**
     * @return Epreuve return the epreuve
     */
    public Epreuve getEpreuve() {
        return epreuve;
    }


    /**
     * @return Spectateur return the spectateur
     */
    public Spectateur getSpectateur() {
        return spectateur;
    }

}
