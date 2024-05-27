package fr.efrei.test.model;

import jakarta.persistence.*;

@Entity
public class Boutique {

    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String uuid;
    
    @Column(nullable = false, length = 100)
    private String nomBoutique;
    
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

}
