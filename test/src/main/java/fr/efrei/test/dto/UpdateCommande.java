package fr.efrei.test.dto;

import jakarta.validation.constraints.*;

public class UpdateCommande {

    @NotBlank(message= "Veuillez choisir le nom de la boutique")
    @Size(min = 2, message = "La nom doit contenir minimun 2 caractères")
	private String nom;

    @NotBlank(message = "Veuillez saisir un spectateur")
    private String spectateur;

    public UpdateCommande(String nom, String spectateur) {
        this.nom = nom;
        this.spectateur = spectateur;
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

    public String getSpectateur() {
        return spectateur;
    }

    public void setSpectateur(String spectateur) {
        this.spectateur = spectateur;
    }

}
