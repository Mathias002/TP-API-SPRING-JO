package fr.efrei.test.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateStade {

    private String uuid;

    @NotBlank(message= "Veuillez renseigner le nom du stade")
    @Size(min = 2, message = "Le nom doit contenir minimun 2 caractères")
    private String nomStade;

    @NotBlank(message= "Veuillez renseigner l'adresse du stade")
    private String adresseStade;

    @NotNull(message = "La capacité du stade ne peut pas être nulle")
    @Min(value = 10000, message = "La capacité du stade doit être au moins de 10000")
    private Integer capaciteStade;

    


    public CreateStade(String nomStade, String adresseStade, Integer capaciteStade) {
        this.nomStade = nomStade;
        this.adresseStade = adresseStade;
        this.capaciteStade = capaciteStade;
    }
    
    /**
     * @return String return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @return String return the nomStade
     */
    public String getNomStade() {
        return nomStade;
    }

    /**
     * @return String return the adresseStade
     */
    public String getAdresseStade() {
        return adresseStade;
    }

    /**
     * @return Integer return the capaciteStade
     */
    public Integer getCapaciteStade() {
        return capaciteStade;
    }

}
