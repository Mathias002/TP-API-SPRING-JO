package fr.efrei.test.service;

import fr.efrei.test.constants.Role;
import fr.efrei.test.dto.LoginDto;
import fr.efrei.test.dto.RegisterDto;
import fr.efrei.test.SpectatorRepository;
import fr.efrei.test.model.Spectateur;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	private final SpectatorRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;

	public AuthService(
			SpectatorRepository userRepository,
			AuthenticationManager authenticationManager,
			PasswordEncoder passwordEncoder
	) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public Spectateur signup(RegisterDto input) {
		Spectateur user = new Spectateur();
		user.setNom(input.getNom());
		user.setPrenom(input.getPrenom());
		user.setEmail(input.getEmail());
		user.setRole(Role.USER);
		user.setPassword(passwordEncoder.encode(input.getPassword()));

		return userRepository.save(user);
	}

	public Spectateur authenticate(LoginDto input) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						input.getEmail(),
						input.getPassword()
				)
		);

		return userRepository.findByEmail(input.getEmail())
				.orElseThrow();
	}
}