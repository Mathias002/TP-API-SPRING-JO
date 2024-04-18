package fr.efrei.test.model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.*;

import jakarta.persistence.Entity;

@Entity
public class Epreuve {

    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(nullable = false)
    private String Uuid_epreuve;  
    
    @Column(nullable = false, length = 100)
    private String Libelle_epreuve;

    @Column(nullable = true, length = 500)
    private String Description_epreuve;

    @Column(nullable = false)
    private Time Duree_epreuve;

    @Column(nullable = false)
    private Date Date_epreuve;
    
    @Column(nullable = false)
    private Boolean Est_ouverte = true;


    public Epreuve(String Uuid_epreuve, String Libelle_epreuve, String Description_epreuve, Time Duree_epreuve, Date Date_epreuve, Boolean Est_ouverte) {
        this.Uuid_epreuve = Uuid_epreuve;
        this.Libelle_epreuve = Libelle_epreuve;
        this.Description_epreuve = Description_epreuve;
        this.Duree_epreuve = Duree_epreuve;
        this.Date_epreuve = Date_epreuve;
        this.Est_ouverte = Est_ouverte;
    }
    

    /**
     * @return String return the Uuid_epreuve
     */
    public String getUuid_epreuve() {
        return Uuid_epreuve;
    }

    /**
     * @param Uuid_epreuve the Uuid_epreuve to set
     */
    public void setUuid_epreuve(String Uuid_epreuve) {
        this.Uuid_epreuve = Uuid_epreuve;
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

    /**
     * @return Boolean return the Est_ouverte
     */
    public Boolean isEst_ouverte() {
        return Est_ouverte;
    }

    /**
     * @param Est_ouverte the Est_ouverte to set
     */
    public void setEst_ouverte(Boolean Est_ouverte) {
        this.Est_ouverte = Est_ouverte;
    }

}
