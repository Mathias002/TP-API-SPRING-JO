package fr.efrei.test.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

import java.util.*;

@Entity
public class Commande {
    
    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(nullable = false)
    private String uuid ;

    @Column(nullable = false)
    private String nom ;

    @CreationTimestamp
	@Column(updatable = false)
	private Date createdAt;

    private LocalDateTime deletedAt = null;

    @ManyToOne
    @JoinColumn(name = "spectateur_uuid")
    private Spectateur spectateur;

    public Commande() {}
    public Commande(String nom) {
        this.nom = nom;
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
