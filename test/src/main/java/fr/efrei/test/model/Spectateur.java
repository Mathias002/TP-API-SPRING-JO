package fr.efrei.test.model;

import fr.efrei.test.constants.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Spectateur implements UserDetails{
    
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	@Column(nullable = false)
    private String uuid;

    @Column(unique = true, length = 100, nullable = false)
    private String email;

    @Column(nullable = false)
    private String Password;

    @Column(nullable = false, length = 50)
    private String Nom;

    @Column(nullable = false, length = 50)
    private String Prenom;

    @Column(nullable = true)
    private Float Solde;

    @CreationTimestamp
	@Column(updatable = false)
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;

	private LocalDateTime deletedAt = null;

	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(mappedBy = "spectateur", cascade = CascadeType.ALL)
    private Set<Billet> billets = new HashSet<>();
	
	@OneToMany(mappedBy = "spectateur", cascade = CascadeType.ALL)
    private Set<Commande> commandes = new HashSet<>();

    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles = Set.of(role);
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.name()));
		}
		return authorities;
	}


	public Spectateur( String email, String Password, String Nom, String Prenom) {
		this.email = email;
		this.Password = Password;
		this.Nom = Nom;
		this.Prenom = Prenom;
	}


    @Override
	public String getUsername() {
		return email;
	}

	public String getPassword() {
		return Password;
	}

	

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
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
     * @return String return the Prenom
     */
    public String getPrenom() {
        return Prenom;
    }

    /**
     * @param Prenom the Prenom to set
     */
    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    /**
     * @return Float return the Solde
     */
    public Float getSolde() {
        return Solde;
    }

    /**
     * @param Solde the Solde to set
     */
    public void setSolde(Float Solde) {
        this.Solde = Solde;
    }

}
