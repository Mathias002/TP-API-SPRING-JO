package fr.efrei.test.dto;

import java.util.*;

import fr.efrei.test.model.Billet;
import jakarta.validation.constraints.*;

public class CreateBoutique {
    
    @NotBlank(message= "Veuillez choisir le nom de la boutique")
    @Size(min = 2, message = "La nom doit contenir minimun 2 caractères")
	private String nom_boutique;

    private Set<Billet> billets = new HashSet<>();

    public CreateBoutique(String nom_boutique, Set<Billet> billets) {
        this.nom_boutique = nom_boutique;
    }

    /**
     * @return String return the nom_boutique
     */
    public String getNom_boutique() {
        return nom_boutique;
    }

    /**
     * @param nom_boutique the nom_boutique to set
     */
    public void setNom_boutique(String nom_boutique) {
        this.nom_boutique = nom_boutique;
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
