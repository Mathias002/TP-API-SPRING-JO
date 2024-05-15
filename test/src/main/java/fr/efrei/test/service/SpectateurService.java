package fr.efrei.test.service;

import fr.efrei.test.dto.CreateSpectateur;
import fr.efrei.test.dto.UpdateSpectateur;
import fr.efrei.test.model.Spectateur;
import fr.efrei.test.repository.SpectateurRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SpectateurService {

	private final SpectateurRepository repository;

	@Autowired
	public SpectateurService(SpectateurRepository repository) {
		this.repository = repository;
	}

	public List<Spectateur> findAllSpectateurs() {
		return repository.findAllByDeletedAtNull();
	}

	public Spectateur findSpectateurById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}

	public Spectateur create(CreateSpectateur spectateur) {
		// ici je suis dans la DTO
		//
		Spectateur spectateurACreer = new Spectateur(
				spectateur.getEmail(),
				spectateur.getPassword(),
				spectateur.getNom(),
				spectateur.getPrenom()
		);
		// je suis dans une entité
		return repository.save(spectateurACreer);
	}

	@Transactional
	public boolean delete(String uuid) {
		Spectateur spectateurASupprimer = findSpectateurById(uuid);
		if(spectateurASupprimer != null && spectateurASupprimer.getDeletedAt() == null) {
			spectateurASupprimer.setDeletedAt(LocalDateTime.now());
			repository.save(spectateurASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String uuid, UpdateSpectateur spectateur) {
		Spectateur spectateurAModifier = findSpectateurById(uuid);

		if(spectateurAModifier != null) {
			spectateurAModifier.setPrenom(spectateur.getPrenom());
			spectateurAModifier.setNom(spectateur.getNom());
			repository.save(spectateurAModifier);
			return true;
		}
		return false;
	}

	public boolean updatePartielle(String uuid, UpdateSpectateur spectateur) {
		Spectateur spectateurAModifier = findSpectateurById(uuid);

		if(spectateurAModifier != null) {
			if(!spectateur.getPrenom().isEmpty()) {
				spectateurAModifier.setPrenom(spectateur.getPrenom());
			}
			if(!spectateur.getNom().isEmpty()) {
				spectateurAModifier.setNom(spectateur.getNom());
			}
			repository.save(spectateurAModifier);
			return true;
		}
		return false;
	}
}
