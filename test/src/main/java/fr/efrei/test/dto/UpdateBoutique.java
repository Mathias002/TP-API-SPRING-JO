package fr.efrei.test.dto;

import java.util.HashSet;
import java.util.*;
import fr.efrei.test.model.Billet;
import jakarta.validation.constraints.*;

public class UpdateBoutique {
    
    @NotBlank
    @Size(min = 2)
	private String Nom_boutique;

    private Set<Billet> billets = new HashSet<>();

    public UpdateBoutique(String Nom_boutique, Set<Billet> billets) {
        this.Nom_boutique = Nom_boutique;
        this.billets = billets;
    }

   /**
     * @return String return the Nom_boutique
     */
    public String getNom_boutique() {
        return Nom_boutique;
    }

    /**
     * @param Nom_boutique the Nom_boutique to set
     */
    public void setNom_boutique(String Nom_boutique) {
        this.Nom_boutique = Nom_boutique;
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