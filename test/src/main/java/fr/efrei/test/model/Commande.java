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
    private String Uuid_commande ;
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Integer Numero_commande ;

    @CreationTimestamp
	@Column(updatable = false)
	private Date Created_at;

    private LocalDateTime Deleted_at = null;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "commande_uuid")
    private Set<Billet> billets = new HashSet<>();


    public Commande(String Uuid_commande, Integer Numero_commande, Date Created_at, LocalDateTime Deleted_at) {
        this.Uuid_commande = Uuid_commande;
        this.Numero_commande = Numero_commande;
        this.Created_at = Created_at;
    }


    public String getUuid_commande() {
        return this.Uuid_commande;
    }

    public void setUuid_commande(String Uuid_commande) {
        this.Uuid_commande = Uuid_commande;
    }

    public Integer getNumero_commande() {
        return this.Numero_commande;
    }

    public Date getCreated_at() {
        return this.Created_at;
    }

    public void setCreated_at(Date Created_at) {
        this.Created_at = Created_at;
    }

    public LocalDateTime getDeleted_at() {
        return this.Deleted_at;
    }

    public void setDeleted_at(LocalDateTime Deleted_at) {
        this.Deleted_at = Deleted_at;
    }
    

}
