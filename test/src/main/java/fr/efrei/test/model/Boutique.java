package fr.efrei.test.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Boutique {

    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String uuid;
    
    @Column(nullable = false, length = 100)
    private String nomBoutique;
    
    @OneToMany(mappedBy = "boutique", cascade = CascadeType.ALL)
    private Set<Billet> billets = new HashSet<>();
    
    public Boutique() {}
    public Boutique( String nomBoutique) {
        this.nomBoutique = nomBoutique;
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
     * @return String return the nomBoutique
     */
    public String getNomBoutique() {
        return nomBoutique;
    }

    /**
     * @param nomBoutique the nomBoutique to set
     */
    public void setNomBoutique(String nomBoutique) {
        this.nomBoutique = nomBoutique;
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
