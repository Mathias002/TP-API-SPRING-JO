package fr.efrei.test.dto;

import java.util.*;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateStade {

    private String uuid;

    @NotBlank(message= "Veuillez renseigner le nom du stade")
    @Size(min = 2, message = "Le nom doit contenir minimun 2 caractères")
    private String nomStade;

    @NotBlank(message= "Veuillez renseigner l'adresse du stade")
    private String adresseStade;

    @NotNull(message = "La capacité du stade ne peut pas être nulle")
    @Min(value = 10000, message = "La capacité du stade doit être au moins de 10000")
    private Integer capaciteStade;

    private boolean estReserve;
    
    /**
     * @return String return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return String return the nomStade
     */
    public String getNomStade() {
        return nomStade;
    }

    /**
     * @param nomStade the nomStade to set
     */
    public void setNomStade(String nomStade) {
        this.nomStade = nomStade;
    }

    /**
     * @return String return the adresseStade
     */
    public String getAdresseStade() {
        return adresseStade;
    }

    /**
     * @param adresseStade the adresseStade to set
     */
    public void setAdresseStade(String adresseStade) {
        this.adresseStade = adresseStade;
    }

    /**
     * @return Integer return the capaciteStade
     */
    public Integer getCapaciteStade() {
        return capaciteStade;
    }

    /**
     * @param capaciteStade the capaciteStade to set
     */
    public void setCapaciteStade(Integer capaciteStade) {
        this.capaciteStade = capaciteStade;
    }

    /**
     * @return boolean return the estReserve
     */
    public boolean isEstReserve() {
        return estReserve;
    }

    /**
     * @param estReserve the estReserve to set
     */
    public void setEstReserve(boolean estReserve) {
        this.estReserve = estReserve;
    }

}
