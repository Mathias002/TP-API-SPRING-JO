package fr.efrei.test.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.util.*;

@Entity
public class Stade {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private String nomStade;

    @Column(nullable = false)
    private String adresseStade;

    @Column(nullable = false)
    @Min(value = 10000)
    private Integer capaciteStade;

    @Column(nullable = false)
    private boolean estReserve = false;

    @ManyToMany
    @JoinTable(
    name = "heberge", 
    joinColumns = @JoinColumn(name = "stade_uuid"), 
    inverseJoinColumns = @JoinColumn(name = "epreuve_uuid"))
    Set<Epreuve> epreuve;

    public Stade() {}
    public Stade(String nomStade, String adresseStade, Integer capaciteStade) {
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
     * @return String return the estReserve
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
