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

    @CreationTimestamp
	@Column(updatable = false)
	private Date Created_at;

    private LocalDateTime deletedAt = null;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "commande_uuid")
    private Set<Billet> billets = new HashSet<>();

    public Commande() {}
    public Commande(Integer Numero_commande, Date Created_at, LocalDateTime deletedAt) {
        this.Created_at = Created_at;
    }


    public String getUuid_commande() {
        return this.uuid;
    }

    public Date getCreated_at() {
        return this.Created_at;
    }

    public void setCreated_at(Date Created_at) {
        this.Created_at = Created_at;
    }

    public LocalDateTime getDeleted_at() {
        return this.deletedAt;
    }

    public void setDeleted_at(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
    


    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
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

}
