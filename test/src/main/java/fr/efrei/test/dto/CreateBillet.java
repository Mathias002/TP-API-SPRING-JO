package fr.efrei.test.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateBillet {
    
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

    public CreateBillet(String nom, Float prix, String boutique, String commande, String epreuve) {
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
     * @return String return the boutique
     */
    public String getBoutique() {
        return boutique;
    }

    /**
     * @return String return the commande
     */
    public String getCommande() {
        return commande;
    }

    /**
     * @return String return the epreuve
     */
    public String getEpreuve() {
        return epreuve;
    }

}
