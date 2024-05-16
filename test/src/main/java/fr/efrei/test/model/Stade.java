package fr.efrei.test.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.*;

@Entity
public class Stade {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false, length = 100)
    @NotBlank
    private String Nom_stade;

    @Column(nullable = false, length = 100)
    @NotBlank
    private String Adresse_stade;

    @Column(nullable = false)
    @NotNull
    @Min(value = 10000)
    private Integer Capacite_stade;

    @Column(nullable = false)
    private boolean Est_reserve = false;

    @ManyToMany
    @JoinTable(
    name = "heberge", 
    joinColumns = @JoinColumn(name = "stade_uuid"), 
    inverseJoinColumns = @JoinColumn(name = "epreuve_uuid"))
    Set<Epreuve> epreuve;

    public Stade() {}
    public Stade(String Nom_stade, String Adresse_stade, Integer Capacite_stade) {
        this.Nom_stade = Nom_stade;
        this.Adresse_stade = Adresse_stade;
        this.Capacite_stade = Capacite_stade;
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
