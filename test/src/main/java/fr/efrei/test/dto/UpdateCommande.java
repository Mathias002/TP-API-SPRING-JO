package fr.efrei.test.dto;

import java.util.*;

import fr.efrei.test.model.Billet;
import jakarta.validation.constraints.*;

public class UpdateCommande {

    @NotBlank(message= "Veuillez choisir le nom de la boutique")
    @Size(min = 2, message = "La nom doit contenir minimun 2 caractères")
	private String nom;

    private Set<Billet> billets = new HashSet<>();
    

    public UpdateCommande(String nom, Set<Billet> billets) {
        this.nom = nom;
        this.billets = billets;
    }

    /**
     * @return String return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
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
