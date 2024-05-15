package fr.efrei.test.dto;

import jakarta.validation.constraints.*;

public class UpdateSpectateur {

    @NotBlank
	private String email;
	
    @NotBlank
    @Size(min = 6)
	private String password;
	
    @NotBlank
	@Size(min = 1, max = 25)
	private String nom;

	@NotBlank
    @Size(min = 1, max = 25)
	private String prenom;

	public UpdateSpectateur(String email, String password, String nom, String prenom) {
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
	}

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
