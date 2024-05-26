package fr.efrei.test.dto;

import fr.efrei.test.validator.StrongPassword;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterDto {

	@NotBlank(message= "Veuillez saisir une adresse email")
	private String email;

	@NotBlank(message= "Veuillez saisir un mot de passe")
	@StrongPassword
	private String password;

	@NotBlank(message= "Veuillez saisir un nom")
	@Size(min = 2, message = "La nom doit contenir minimun 2 caractères")
	private String nom;
	
	@NotBlank(message= "Veuillez saisir un prénom")
    @Size(min = 2, message = "La prénom doit contenir minimun 2 caractères")
	private String prenom;

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
		return nom;
	}

	public void setNom(String Nom) {
		this.nom = Nom;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String Prenom) {
		this.prenom = Prenom;
	}
}