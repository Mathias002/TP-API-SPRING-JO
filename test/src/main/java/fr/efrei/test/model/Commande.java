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
    private String Nom ;

    @CreationTimestamp
	@Column(updatable = false)
	private Date Created_at;

    private LocalDateTime deletedAt = null;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private Set<Billet> billets = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "spectateur_uuid")
    private Spectateur spectateur;

    public Commande() {}
    public Commande(String Nom, Date Created_at, LocalDateTime deletedAt) {
        this.Nom = Nom;
        this.Created_at = Created_at;
        this.deletedAt = deletedAt;
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
