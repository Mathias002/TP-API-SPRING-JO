package fr.efrei.test.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Epreuve {

    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(nullable = false)
    private String uuid;  
    
    @Column(nullable = false, length = 100)
    private String libelleEpreuve;

    @Column(nullable = true, length = 500)
    private String descriptionEpreuve;

    @Column(nullable = false)
    private Date dateEpreuve;
    
    @Column(nullable = false)
    private boolean estOuverte = false;
    
    @ManyToMany(mappedBy = "epreuve")
    Set<Stade> stade = new HashSet<>();

    public Epreuve() {}
    public Epreuve(String libelleEpreuve, String descriptionEpreuve, Date dateEpreuve) {
        this.libelleEpreuve = libelleEpreuve;
        this.descriptionEpreuve = descriptionEpreuve;
        this.dateEpreuve = dateEpreuve;
    }
    
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

    public void setStade(Set<Stade> stade) {
        this.stade = stade;
    }

    public Set<Stade> getStade() {
        return stade;
        // idEpreuve : blabla 
        // idStade : toto
    }

}
