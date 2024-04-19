package fr.efrei.test.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Boutique {

    
    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(nullable = false)
    private String Uuid_boutique;
    
    @Column(nullable = false, length = 100)
    private String Nom_boutique;
    
    
    public Boutique(String Uuid_boutique, String Nom_boutique) {
        this.Uuid_boutique = Uuid_boutique;
        this.Nom_boutique = Nom_boutique;
    }
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "boutique_uuid")
    private Set<Billet> billets = new HashSet<>();

    /**
     * @return Integer return the Uuid_boutique
     */
    public String getId_boutique() {
        return Uuid_boutique;
    }

    /**
     * @return String return the Nom_boutique
     */
    public String getNom_boutique() {
        return Nom_boutique;
    }

    /**
     * @param Nom_boutique the Nom_boutique to set
     */
    public void setNom_boutique(String Nom_boutique) {
        this.Nom_boutique = Nom_boutique;
    }

}
