package fr.efrei.test.model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.*;

@Entity
public class Epreuve {

    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(nullable = false)
    private String uuid;  
    
    @Column(nullable = false, length = 100)
    private String Libelle_epreuve;

    @Column(nullable = true, length = 500)
    private String Description_epreuve;

    @Column(nullable = false)
    private Time Duree_epreuve;

    @Column(nullable = false)
    private Date Date_epreuve;
    
    @Column(nullable = false)
    private boolean Est_ouverte = true;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "epreuve_uuid")
    private Set<Billet> billets = new HashSet<>();

    public Epreuve() {}
    public Epreuve(String Libelle_epreuve, String Description_epreuve, Time Duree_epreuve, Date Date_epreuve, boolean Est_ouverte) {
        this.Libelle_epreuve = Libelle_epreuve;
        this.Description_epreuve = Description_epreuve;
        this.Duree_epreuve = Duree_epreuve;
        this.Date_epreuve = Date_epreuve;
        this.Est_ouverte = Est_ouverte;
    }
    

    /**
     * @return String return the uuid
     */
    public String getUuid_epreuve() {
        return uuid;
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
     * @return boolean return the Est_ouverte
     */
    public boolean isEst_ouverte() {
        return Est_ouverte;
    }

    /**
     * @param Est_ouverte the Est_ouverte to set
     */
    public void setEst_ouverte(boolean Est_ouverte) {
        this.Est_ouverte = Est_ouverte;
    }

    /**
     * @return Set<Billet> return the billets
     */
    public Set<Billet> getBillets() {
        return billets;
    }

    /**
     * @param billets the billets to set
     */
    public void setBillets(Set<Billet> billets) {
        this.billets = billets;
    }

}
