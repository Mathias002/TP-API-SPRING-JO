package fr.efrei.test.model;

import fr.efrei.test.constants.Role;
import fr.efrei.test.validator.StrongPassword;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
    private String Uuid_spectateur;

    @Column(unique = true, length = 100, nullable = false)
    private String Email;

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

	@Enumerated(EnumType.STRING)
	private Role role;

    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles = Set.of(role);
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.name()));
		}
		return authorities;
	}

    @Override
	public String getUsername() {
		return Email;
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
}
