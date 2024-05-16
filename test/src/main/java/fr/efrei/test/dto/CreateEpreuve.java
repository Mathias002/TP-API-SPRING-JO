package fr.efrei.test.dto;

import jakarta.validation.constraints.NotBlank;

import java.sql.Time;
import java.util.*;

public class CreateEpreuve {
    
    @NotBlank(message= "Veuillez choisir un libelle")
    private String Libelle_epreuve;

    @NotBlank(message= "Veuillez choisir une description")
    private String Description_epreuve;

    @NotBlank(message= "Veuillez choisir la durée de l'épreuve")
    private Time Duree_epreuve;

    @NotBlank(message= "Veuillez choisir la date de l'épreuve")
    private Date Date_epreuve;  
    
    @NotBlank
    private boolean Est_ouverte = false;

    public CreateEpreuve(String Libelle_epreuve, String Description_epreuve, Time Duree_epreuve, Date Date_epreuve) {
        this.Libelle_epreuve = Libelle_epreuve;
        this.Description_epreuve = Description_epreuve;
        this.Duree_epreuve = Duree_epreuve;
        this.Date_epreuve = Date_epreuve;
    }
    

    /**
     * @return String return the Libelle_epreuve
     */
    public String getLibelle_epreuve() {
        return Libelle_epreuve;
    }

    /**
     * @param Libelle_epreuve the Libelle_epreuve to set
     */
    public void setLibelle_epreuve(String Libelle_epreuve) {
        this.Libelle_epreuve = Libelle_epreuve;
    }

    /**
     * @return String return the Description_epreuve
     */
    public String getDescription_epreuve() {
        return Description_epreuve;
    }

    /**
     * @param Description_epreuve the Description_epreuve to set
     */
    public void setDescription_epreuve(String Description_epreuve) {
        this.Description_epreuve = Description_epreuve;
    }

    /**
     * @return Time return the Duree_epreuve
     */
    public Time getDuree_epreuve() {
        return Duree_epreuve;
    }

    /**
     * @param Duree_epreuve the Duree_epreuve to set
     */
    public void setDuree_epreuve(Time Duree_epreuve) {
        this.Duree_epreuve = Duree_epreuve;
    }

    /**
     * @return Date return the Date_epreuve
     */
    public Date getDate_epreuve() {
        return Date_epreuve;
    }

    /**
     * @param Date_epreuve the Date_epreuve to set
     */
    public void setDate_epreuve(Date Date_epreuve) {
        this.Date_epreuve = Date_epreuve;
    }

}
