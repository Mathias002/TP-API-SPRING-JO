package fr.efrei.test.service;

import fr.efrei.test.dto.CreateEpreuve;
import fr.efrei.test.dto.UpdateEpreuve;
import fr.efrei.test.model.Epreuve;
import fr.efrei.test.repository.EpreuveRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EpreuveService {

	private final EpreuveRepository repository;

	@Autowired
	public EpreuveService(EpreuveRepository repository) {
		this.repository = repository;
	}

	public List<Epreuve> findAllEpreuves() {
		return repository.findAll();
	}

	public Epreuve findEpreuveById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}

	public Epreuve create(CreateEpreuve epreuve) {
		// ici je suis dans la DTO
		//
		Epreuve epreuveACreer = new Epreuve(
				epreuve.getLibelleEpreuve(),
				epreuve.getDescriptionEpreuve(),
				epreuve.getDateEpreuve()
		);
		// je suis dans une entité
		return repository.save(epreuveACreer);
	}

	@Transactional
	public boolean delete(String uuid) {
		Epreuve epreuveASupprimer = findEpreuveById(uuid);
		if(epreuveASupprimer != null ){
			repository.save(epreuveASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String uuid, UpdateEpreuve epreuve) {
		Epreuve epreuveAModifier = findEpreuveById(uuid);

		if(epreuveAModifier != null) {
			epreuveAModifier.setLibelleEpreuve(epreuve.getLibelleEpreuve());
			epreuveAModifier.setDescriptionEpreuve(epreuve.getDescriptionEpreuve());
			epreuveAModifier.setDateEpreuve(epreuve.getDateEpreuve());
			epreuveAModifier.setEstOuverte(epreuve.isEstOuverte());
			repository.save(epreuveAModifier);
			return true;
		}
		return false;
	}

	public boolean updatePartielle(String uuid, UpdateEpreuve epreuve) {
		Epreuve epreuveAModifier = findEpreuveById(uuid);

		if(epreuveAModifier != null) {
			if(!epreuve.getLibelleEpreuve().isEmpty()) {
				epreuveAModifier.setLibelleEpreuve(epreuve.getLibelleEpreuve());
                epreuveAModifier.setDescriptionEpreuve(epreuve.getDescriptionEpreuve());
                epreuveAModifier.setDateEpreuve(epreuve.getDateEpreuve());
                epreuveAModifier.setEstOuverte(epreuve.isEstOuverte());
			}
			repository.save(epreuveAModifier);
			return true;
		}
		return false;
	}
}
