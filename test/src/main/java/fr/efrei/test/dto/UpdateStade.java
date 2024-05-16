package fr.efrei.test.dto;

import java.util.*;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateStade {

    private String uuid;

    @NotBlank(message= "Veuillez renseigner le nom du stade")
    private String Nom_stade;

    @NotBlank(message= "Veuillez renseigner l'adresse du stade")
    private String Adresse_stade;

    @NotNull(message = "La capacité du stade ne peut pas être nulle")
    @Min(value = 10000, message = "La capacité du stade doit être au moins de 10000")
    private Integer Capacite_stade;

    private boolean Est_reserve;

    public UpdateStade(String Nom_stade, String Adresse_stade, Integer Capacite_stade, boolean Est_reserve) {
        this.Nom_stade = Nom_stade;
        this.Adresse_stade = Adresse_stade;
        this.Capacite_stade = Capacite_stade;
        this.Est_reserve = Est_reserve;
    }
    
    /**
     * @return String return the uuid
     */
    public String getUuid_stade() {
        return uuid;
    }
    
    /**
     * @return String return the Nom_stade
     */
    public String getNom_stade() {
        return Nom_stade;
    }

    /**
     * @param Nom_stade the Nom_stade to set
     */
    public void setNom_stade(String Nom_stade) {
        this.Nom_stade = Nom_stade;
    }

    /**
     * @return String return the Adresse_stade
     */
    public String getAdresse_stade() {
        return Adresse_stade;
    }

    /**
     * @param Adresse_stade the Adresse_stade to set
     */
    public void setAdresse_stade(String Adresse_stade) {
        this.Adresse_stade = Adresse_stade;
    }

    /**
     * @return Integer return the Capacite_stade
     */
    public Integer getCapacite_stade() {
        return Capacite_stade;
    }

    /**
     * @param Capacite_stade the Capacite_stade to set
     */
    public void setCapacite_stade(Integer Capacite_stade) {
        this.Capacite_stade = Capacite_stade;
    }

    /**
     * @return String return the Est_reserve
     */
    public boolean getEst_reserve() {
        return Est_reserve;
    }

    /**
     * @param Est_reserve the Est_reserve to set
     */
    public void setEst_reserve(boolean Est_reserve) {
        this.Est_reserve = Est_reserve;
    }

}
