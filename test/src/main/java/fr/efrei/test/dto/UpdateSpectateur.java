package fr.efrei.test.dto;

import jakarta.validation.constraints.*;

public class UpdateSpectateur {

    @NotBlank(message= "Veuillez saisir un mot de passe")
	private String email;
	
    @NotBlank(message= "Veuillez saisir un mot de passe")
    @Size(min = 6)
	private String password;
	
    @NotBlank(message= "Veuillez choisir un nom")
	@Size(min = 1, max = 25)
	private String nom;

	@NotBlank(message= "Veuillez choisir un prénom")
    @Size(min = 1, max = 25)
	private String prenom;

    private Float solde = 0.00f;


    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @return String return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return Float return the solde
     */
    public Float getSolde() {
        return solde;
    }

    /**
     * @param solde the solde to set
     */
    public void setSolde(Float solde) {
        this.solde = solde;
    }

}
