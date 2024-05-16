package fr.efrei.test.dto;

import jakarta.validation.constraints.*;

public class CreateCommande {

    @NotBlank(message= "Veuillez choisir le nom de la boutique")
    @Size(min = 2, message = "La nom doit contenir minimun 2 caractères")
	private String nom;
    
    public CreateCommande(String nom) {
        this.nom = nom;
    }

    public CreateCommande(String nom, String spectateur) {
        this.nom = nom;
        this.spectateur = spectateur;
    }

    @NotBlank(message = "Veuillez saisir un spectateur")
    private String spectateur;

    /**
     * @return String return the nom
     */
    public String getNom() {
        return nom;
    }

    public String getSpectateur() {
        return spectateur;
    }

}
