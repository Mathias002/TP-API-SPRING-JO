package fr.efrei.test.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.util.*;

@Entity
public class Billet {
 
    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(nullable = false)
    private String uuid;
    
	@Column(nullable = false)
    private String Nom;

    @Column(nullable = false)
    private Float Prix;

    @CreationTimestamp
	@Column(updatable = false)
	private Date Created_at;

    private LocalDateTime deletedAt = null;
   
    @Column(nullable = false)
    private boolean IsValid = true;
    
    @ManyToOne
    @JoinColumn(name = "boutique_uuid")
    private Boutique boutique;

    @ManyToOne
    @JoinColumn(name = "commande_uuid")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "epreuve_uuid")
    private Epreuve epreuve;

    @ManyToOne
    @JoinColumn(name = "spectateur_uuid")
    private Spectateur spectateur;

    public Billet() {}
    public Billet(Float Prix, String Nom, Date Created_at, LocalDateTime deletedAt, boolean IsValid) {
        this.Prix = Prix;
        this.Nom = Nom;
        this.Created_at = Created_at;
        this.deletedAt = deletedAt;
        this.IsValid = IsValid;
    }    

    /**
     * @return String return the uuid
     */
    public String getUuid_billet() {
        return uuid;
    }

    /**
     * @return Float return the Prix
     */
    public Float getPrix() {
        return Prix;
    }

    /**
     * @param Prix the Prix to set
     */
    public void setPrix(Float Prix) {
        this.Prix = Prix;
    }

    /**
     * @return Boolean return the IsValid
     */
    public boolean isIsValid() {
        return IsValid;
    }

    /**
     * @param IsValid the IsValid to set
     */
    public void setIsValid(boolean IsValid) {
        this.IsValid = IsValid;
    }


    /**
     * @return Date return the Created_at
     */
    public Date getCreated_at() {
        return Created_at;
    }

    /**
     * @param Created_at the Created_at to set
     */
    public void setCreated_at(Date Created_at) {
        this.Created_at = Created_at;
    }

    /**
     * @return LocalDateTime return the deletedAt
     */
    public LocalDateTime getDeleted_at() {
        return deletedAt;
    }

    /**
     * @param deletedAt the deletedAt to set
     */
    public void setDeleted_at(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * @return String return the Nom
     */
    public String getNom() {
        return Nom;
    }

    /**
     * @param Nom the Nom to set
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

}
