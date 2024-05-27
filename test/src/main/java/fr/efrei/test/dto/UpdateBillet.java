package fr.efrei.test.dto;
import fr.efrei.test.model.Boutique;
import fr.efrei.test.model.Commande;
import fr.efrei.test.model.Epreuve;
import fr.efrei.test.model.Spectateur;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateBillet {
    
    @NotBlank(message = "Veuillez saisir un nom")
    @Size(min = 2, message = "Le nom doit contenir minimun 2 caractères")
    private String nom;

    @NotNull(message = "Veuillez saisir un prix")
    private Float prix;
   
    private boolean isValid = false;
    
    @NotBlank(message = "Veuillez saisir une boutique")
    private String boutique;

    @NotBlank(message = "Veuillez saisir une commande")
    private String commande;

    @NotBlank(message = "Veuillez saisir une epreuve")
    private String epreuve;

    public UpdateBillet(String nom, Float prix, String boutique, String commande, String epreuve) {
        this.nom = nom;
        this.prix = prix;
        this.boutique = boutique;
        this.commande = commande;
        this.epreuve = epreuve;
    }

    /**
     * @return String return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return Float return the prix
     */
    public Float getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(Float prix) {
        this.prix = prix;
    }

    /**
     * @return boolean return the isValid
     */
    public boolean isIsValid() {
        return isValid;
    }

    /**
     * @param isValid the isValid to set
     */
    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    /**
     * @return String return the boutique
     */
    public String getBoutique() {
        return boutique;
    }

    /**
     * @param boutique the boutique to set
     */
    public void setBoutique(String boutique) {
        this.boutique = boutique;
    }

    /**
     * @return String return the commande
     */
    public String getCommande() {
        return commande;
    }

    /**
     * @param commande the commande to set
     */
    public void setCommande(String commande) {
        this.commande = commande;
    }

    /**
     * @return String return the epreuve
     */
    public String getEpreuve() {
        return epreuve;
    }

    /**
     * @param epreuve the epreuve to set
     */
    public void setEpreuve(String epreuve) {
        this.epreuve = epreuve;
    }

}
