package fr.efrei.test.dto;

public class UpdateSpectateur {

	private String email;

	private String Password;

	private String Nom;

	private String Prenom;

	public UpdateSpectateur(String email, String Password, String Nom, String Prenom) {
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
