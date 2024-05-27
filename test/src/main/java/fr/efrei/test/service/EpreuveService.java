package fr.efrei.test.service;

import fr.efrei.test.dto.CreateEpreuve;
import fr.efrei.test.dto.UpdateEpreuve;
import fr.efrei.test.model.Epreuve;
import fr.efrei.test.model.Stade;
import fr.efrei.test.repository.EpreuveRepository;
import fr.efrei.test.repository.StadeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EpreuveService {

	private final EpreuveRepository repository;
	private final StadeRepository stadeRepository;

	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Autowired
	public EpreuveService(EpreuveRepository repository, StadeRepository stadeRepository) {
		this.repository = repository;
		this.stadeRepository = stadeRepository;
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

		Set<Stade> stades = new HashSet<>();
        for (String uuid : epreuve.getStadeUuids()) {
            Stade stade = stadeRepository.findOneByUuid(uuid).orElseThrow(() ->
                new EntityNotFoundException("Stade non trouvé avec l'UUID: " + uuid));
            stades.add(stade);
        }
        epreuveACreer.setStade(stades);
		
		// je suis dans une entité
		Epreuve savedEpreuve =  repository.save(epreuveACreer);

		for (String stadeUuid : epreuve.getStadeUuids()) {
            jdbcTemplate.update("INSERT INTO heberge (stade_uuid, epreuve_uuid) VALUES (?, ?)",
                    stadeUuid, savedEpreuve.getUuid());
        }

		return savedEpreuve;

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

			Epreuve savedEpreuve =  repository.save(epreuveAModifier);

			// Suppression des relations existantes
            String sqlDelete = "DELETE FROM heberge WHERE epreuve_uuid = '" + savedEpreuve.getUuid() + "'";
            jdbcTemplate.update(sqlDelete);

			for (String stadeUuid : epreuve.getStadeUuids()) {
				jdbcTemplate.update("INSERT INTO heberge (stade_uuid, epreuve_uuid) VALUES (?, ?)",
						stadeUuid, savedEpreuve.getUuid());
			}
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
				Epreuve savedEpreuve =  repository.save(epreuveAModifier);
	
				// Suppression des relations existantes
				String sqlDelete = "DELETE FROM heberge WHERE epreuve_uuid = '" + savedEpreuve.getUuid() + "'";
				jdbcTemplate.update(sqlDelete);
	
				for (String stadeUuid : epreuve.getStadeUuids()) {
					jdbcTemplate.update("INSERT INTO heberge (stade_uuid, epreuve_uuid) VALUES (?, ?)",
							stadeUuid, savedEpreuve.getUuid());
				}
				return true;
			}
		}
		return false;
	}
}
