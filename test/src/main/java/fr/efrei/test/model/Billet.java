package fr.efrei.test.model;

import jakarta.persistence.*;

@Entity
public class Billet {

    
    
    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(nullable = false)
    private String Uuid_billet;
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Integer Numero_billet;

    @Column(nullable = false)
    private Float Prix;
   
    @Column(nullable = false)
    private boolean IsValid = true;

    public Billet(String Uuid_billet, Integer Numero_billet, Float Prix, boolean IsValid) {
        this.Uuid_billet = Uuid_billet;
        this.Numero_billet = Numero_billet;
        this.Prix = Prix;
        this.IsValid = IsValid;
    }    


    /**
     * @return String return the Uuid_billet
     */
    public String getUuid_billet() {
        return Uuid_billet;
    }

    /**
     * @param Uuid_billet the Uuid_billet to set
     */
    public void setUuid_billet(String Uuid_billet) {
        this.Uuid_billet = Uuid_billet;
    }

    /**
     * @return Integer return the Numero_billet
     */
    public Integer getNumero_billet() {
        return Numero_billet;
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

    /**
     * @return Boolean return the IsValid
     */
    public boolean isIsValid() {
        return IsValid;
    }

    /**
     * @param IsValid the IsValid to set
     */
    public void setIsValid(boolean IsValid) {
        this.IsValid = IsValid;
    }

}
