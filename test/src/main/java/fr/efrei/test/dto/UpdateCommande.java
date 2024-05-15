package fr.efrei.test.dto;

import java.util.*;

import fr.efrei.test.model.Billet;
import jakarta.validation.constraints.*;

public class UpdateCommande {

    @NotBlank
    @Size(min = 2)
	private String Nom;

    private Set<Billet> billets = new HashSet<>();
    

    public UpdateCommande(String Nom, Set<Billet> billets) {
        this.Nom = Nom;
        this.billets = billets;
    }

    /**
     * @return String return the Nom
     */
    public String getNom() {
        return Nom;
    }

    /**
     * @param Nom the Nom to set
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
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
