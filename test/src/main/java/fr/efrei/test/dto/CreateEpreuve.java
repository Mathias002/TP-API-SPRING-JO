package fr.efrei.test.dto;

import jakarta.validation.constraints.NotBlank;

import java.sql.Time;
import java.util.*;

public class CreateEpreuve {
    
    @NotBlank(message= "Veuillez choisir un libelle")
    private String libelleEpreuve;

    @NotBlank(message= "Veuillez choisir une description")
    private String descriptionEpreuve;

    @NotBlank(message= "Veuillez choisir la durée de l'épreuve")
    private Time dureeEpreuve;

    @NotBlank(message= "Veuillez choisir la date de l'épreuve")
    private Date dateEpreuve;  
    
    @NotBlank
    private boolean estOuverte = false;

    public CreateEpreuve(String libelleEpreuve, String descriptionEpreuve, Time dureeEpreuve, Date dateEpreuve) {
        this.libelleEpreuve = libelleEpreuve;
        this.descriptionEpreuve = descriptionEpreuve;
        this.dureeEpreuve = dureeEpreuve;
        this.dateEpreuve = dateEpreuve;
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
     * @return Time return the dureeEpreuve
     */
    public Time getDureeEpreuve() {
        return dureeEpreuve;
    }

    /**
     * @param dureeEpreuve the dureeEpreuve to set
     */
    public void setDureeEpreuve(Time dureeEpreuve) {
        this.dureeEpreuve = dureeEpreuve;
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

}
