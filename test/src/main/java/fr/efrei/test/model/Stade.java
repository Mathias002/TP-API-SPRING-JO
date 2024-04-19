package fr.efrei.test.model;

import jakarta.persistence.*;

import jakarta.persistence.Entity;

@Entity
public class Stade {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String Uuid_stade;

    @Column(nullable = false, length = 100)
    private String Nom_stade;

    @Column(nullable = false, length = 100)
    private String Adresse_stade;

    @Column(nullable = false)
    private Integer Capacite_stade;

    @Column(nullable = false)
    private boolean Est_reserve;


    public Stade(String Uuid_stade, String Nom_stade, String Adresse_stade, Integer Capacite_stade, boolean Est_reserve) {
        this.Uuid_stade = Uuid_stade;
        this.Nom_stade = Nom_stade;
        this.Adresse_stade = Adresse_stade;
        this.Capacite_stade = Capacite_stade;
        this.Est_reserve = Est_reserve;
    }
    
    /**
     * @return String return the Uuid_stade
     */
    public String getUuid_stade() {
        return Uuid_stade;
    }

    /**
     * @param Uuid_stade the Uuid_stade to set
     */
    public void setUuid_stade(String Uuid_stade) {
        this.Uuid_stade = Uuid_stade;
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
