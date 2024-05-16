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

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return String return the Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return String return the Nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return String return the Prenom
     */
    public String getPrenom() {
        return prenom;
    }

}
