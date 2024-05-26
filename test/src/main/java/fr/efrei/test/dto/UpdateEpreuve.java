package fr.efrei.test.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.*;

public class UpdateEpreuve {

    private String uuid = this.getUuid();
    
    @NotBlank(message= "Veuillez choisir un libelle")
    private String libelleEpreuve;

    @NotBlank(message= "Veuillez choisir une description")
    private String descriptionEpreuve;

    @NotNull(message= "Veuillez choisir la date de l'épreuve")
    private Date dateEpreuve;  
    
    private boolean estOuverte;

    private Set<String> stadeUuids;

    /**
     * @return String return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @return String return the libelleEpreuve
     */
    public String getLibelleEpreuve() {
        return libelleEpreuve;
    }

    /**
     * @param libelleEpreuve the libelleEpreuve to set
     */
    public void setLibelleEpreuve(String libelleEpreuve) {
        this.libelleEpreuve = libelleEpreuve;
    }

    /**
     * @return String return the descriptionEpreuve
     */
    public String getDescriptionEpreuve() {
        return descriptionEpreuve;
    }

    /**
     * @param descriptionEpreuve the descriptionEpreuve to set
     */
    public void setDescriptionEpreuve(String descriptionEpreuve) {
        this.descriptionEpreuve = descriptionEpreuve;
    }

    /**
     * @return Date return the dateEpreuve
     */
    public Date getDateEpreuve() {
        return dateEpreuve;
    }

    /**
     * @param dateEpreuve the dateEpreuve to set
     */
    public void setDateEpreuve(Date dateEpreuve) {
        this.dateEpreuve = dateEpreuve;
    }

    /**
     * @return boolean return the estOuverte
     */
    public boolean isEstOuverte() {
        return estOuverte;
    }

    /**
     * @param estOuverte the estOuverte to set
     */
    public void setEstOuverte(boolean estOuverte) {
        this.estOuverte = estOuverte;
    }


    /**
     * @return Set<String> return the stadeUuids
     */
    public Set<String> getStadeUuids() {
        return stadeUuids;
    }

    /**
     * @param stadeUuids the stadeUuids to set
     */
    public void setStadeUuids(Set<String> stadeUuids) {
        this.stadeUuids = stadeUuids;
    }

}
