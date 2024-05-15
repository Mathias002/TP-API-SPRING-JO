package fr.efrei.test.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Boutique {

    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    
    @Column(nullable = false, length = 100)
    private String Nom_boutique;
    
    @OneToMany(mappedBy = "boutique", cascade = CascadeType.ALL)
    private Set<Billet> billets = new HashSet<>();
    

    public Boutique() {}
    public Boutique( String Nom_boutique, Set<Billet> billets) {
        this.Nom_boutique = Nom_boutique;
        this.billets = billets;
    }
    /**
     * @return Integer return the uuid
     */
    public String getId_boutique() {
        return uuid;
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
