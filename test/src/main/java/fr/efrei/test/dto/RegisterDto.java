package fr.efrei.test.dto;

import fr.efrei.test.validator.StrongPassword;

public class RegisterDto {
	private String email;

	@StrongPassword
	private String password;

	private String Nom;
	
	private String Prenom;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String Nom) {
		this.Nom = Nom;
	}
	
	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String Prenom) {
		this.Prenom = Prenom;
	}
}