package fr.efrei.test.dto;

import jakarta.validation.constraints.*;

public class CreateBoutique {
    
    @NotBlank
    @Size(min = 2)
	private String Nom_boutique;

    public CreateBoutique(String Nom_boutique) {
		this.Nom_boutique = Nom_boutique;
	}

    /**
     * @return String return the Nom_boutique
     */
    public String getNom_boutique() {
        return Nom_boutique;
    }

}
