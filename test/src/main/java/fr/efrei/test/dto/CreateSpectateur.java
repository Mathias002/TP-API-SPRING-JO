package fr.efrei.test.dto;

import jakarta.validation.constraints.*;


public class CreateSpectateur {

	@NotBlank
	private String email;
	
    @NotBlank
    @Size(min = 6)
	private String Password;
	
    @NotBlank
	@Size(min = 1, max = 25)
	private String Nom;

	@NotBlank
    @Size(min = 1, max = 25)
	private String Prenom;

	public CreateSpectateur(String email, String Password, String Nom, String Prenom) {
		this.email = email;
		this.Password = Password;
		this.Nom = Nom;
		this.Prenom = Prenom;
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
        return Password;
    }

    /**
     * @return String return the Nom
     */
    public String getNom() {
        return Nom;
    }

    /**
     * @return String return the Prenom
     */
    public String getPrenom() {
        return Prenom;
    }

}
