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
    private String nom;

    @Column(nullable = false)
    private Float prix;

    @CreationTimestamp
	@Column(updatable = false)
	private Date createdAt;

    private LocalDateTime deletedAt = null;
   
    @Column(nullable = false)
    private boolean isValid = false;
    
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

    // completer le constructeur
    public Billet() {}
    public Billet(String nom, Float prix, Boutique boutique, Commande commande, Epreuve epreuve, Spectateur spectateur ) {
        this.nom = nom;
        this.prix = prix;
        this.boutique = boutique;
        this.commande = commande;
        this.epreuve = epreuve;
        this.spectateur = spectateur;
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
     * @return String return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return Float return the prix
     */
    public Float getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(Float prix) {
        this.prix = prix;
    }

    /**
     * @return Date return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return LocalDateTime return the deletedAt
     */
    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    /**
     * @param deletedAt the deletedAt to set
     */
    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * @return boolean return the isValid
     */
    public boolean isIsValid() {
        return isValid;
    }

    /**
     * @param isValid the isValid to set
     */
    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    /**
     * @return Boutique return the boutique
     */
    public Boutique getBoutique() {
        return boutique;
    }

    /**
     * @param boutique the boutique to set
     */
    public void setBoutique(Boutique boutique) {
        this.boutique = boutique;
    }

    /**
     * @return Commande return the commande
     */
    public Commande getCommande() {
        return commande;
    }

    /**
     * @param commande the commande to set
     */
    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    /**
     * @return Epreuve return the epreuve
     */
    public Epreuve getEpreuve() {
        return epreuve;
    }

    /**
     * @param epreuve the epreuve to set
     */
    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    /**
     * @return Spectateur return the spectateur
     */
    public Spectateur getSpectateur() {
        return spectateur;
    }

    /**
     * @param spectateur the spectateur to set
     */
    public void setSpectateur(Spectateur spectateur) {
        this.spectateur = spectateur;
    }

}
