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
    private String password;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false, length = 50)
    private String prenom;

    @Column(nullable = true)
    private Float solde;

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

	public Spectateur( String email, String password, String nom, String prenom) {
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
	}

    @Override
	public String getUsername() {
		return email;
	}

	public String getPassword() {
		return password;
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
     * @return String return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return String return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return Float return the solde
     */
    public Float getSolde() {
        return solde;
    }

    /**
     * @param solde the solde to set
     */
    public void setSolde(Float solde) {
        this.solde = solde;
    }

    /**
     * @return Role return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
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
     * @return Set<Commande> return the commandes
     */
    public Set<Commande> getCommandes() {
        return commandes;
    }

    /**
     * @param commandes the commandes to set
     */
    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }

}
