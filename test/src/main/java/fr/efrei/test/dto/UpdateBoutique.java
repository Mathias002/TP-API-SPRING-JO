package fr.efrei.test.dto;

import java.util.*;
import fr.efrei.test.model.Billet;
import jakarta.validation.constraints.*;

public class UpdateBoutique {
    
    @NotBlank(message= "Veuillez choisir le nom de la boutique")
    @Size(min = 2, message = "La nom doit contenir minimun 2 caractères")
	private String nomBoutique;

    private Set<Billet> billets = new HashSet<>();

    public UpdateBoutique(String Nom_boutique, Set<Billet> billets) {
        this.nomBoutique = Nom_boutique;
        this.billets = billets;
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

    /**
     * @return Set<Billet> return the billets
     */
    public Set<Billet> getBillets() {
        return billets;
    }

    /**
     * @param billets the billets to set
     */
    public void setBillets(Set<Billet> billets) {
        this.billets = billets;
    }

}