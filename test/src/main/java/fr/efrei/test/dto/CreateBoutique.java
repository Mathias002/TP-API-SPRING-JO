package fr.efrei.test.dto;

import jakarta.validation.constraints.*;

public class CreateBoutique {
    
    @NotBlank(message= "Veuillez choisir le nom de la boutique")
    @Size(min = 2, message = "La nom doit contenir minimun 2 caractères")
	private String nomBoutique;

    public CreateBoutique(String nomBoutique) {
        this.nomBoutique = nomBoutique;
    }

    /**
     * @return String return the nomBoutique
     */
    public String getNomBoutique() {
        return nomBoutique;
    }

    /**
     * @param nomBoutique the nomBoutique to set
     */
    public void setNomBoutique(String nomBoutique) {
        this.nomBoutique = nomBoutique;
    }

}
