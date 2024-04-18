package fr.efrei.test.model;

import jakarta.persistence.*;

@Entity
public class Billet {
    
    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(nullable = false)
    private String Uuid_epreuve;
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Integer Numero_billet;

    @Column(nullable = false)
    private Float Prix;


    public Billet(String Uuid_epreuve, Integer Numero_billet, Float Prix) {
        this.Uuid_epreuve = Uuid_epreuve;
        this.Numero_billet = Numero_billet;
        this.Prix = Prix;
    }    

    /**
     * @return String return the Uuid_epreuve
     */
    public String getUuid_epreuve() {
        return Uuid_epreuve;
    }

    /**
     * @param Uuid_epreuve the Uuid_epreuve to set
     */
    public void setUuid_epreuve(String Uuid_epreuve) {
        this.Uuid_epreuve = Uuid_epreuve;
    }

    /**
     * @return Integer return the Numero_billet
     */
    public Integer getNumero_billet() {
        return Numero_billet;
    }

    /**
     * @param Numero_billet the Numero_billet to set
     */
    public void setNumero_billet(Integer Numero_billet) {
        this.Numero_billet = Numero_billet;
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

}
