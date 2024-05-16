package fr.efrei.test.service;

import fr.efrei.test.dto.CreateStade;
import fr.efrei.test.dto.UpdateStade;
import fr.efrei.test.model.Stade;
import fr.efrei.test.repository.StadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StadeService {

	private final StadeRepository repository;

	@Autowired
	public StadeService(StadeRepository repository) {
		this.repository = repository;
	}

	public List<Stade> findAllStades() {
		return repository.findAll();
	}

	public Stade findStadeById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}

	public Stade create(CreateStade stade) {
		// ici je suis dans la DTO
		//
		Stade stadeACreer = new Stade(
				stade.getNom_stade(),
				stade.getAdresse_stade(),
				stade.getCapacite_stade()
		);
		// je suis dans une entité
		return repository.save(stadeACreer);
	}

	@Transactional
	public boolean delete(String uuid) {
		Stade stadeASupprimer = findStadeById(uuid);
		if(stadeASupprimer != null ){
			repository.save(stadeASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String uuid, UpdateStade stade) {
		Stade stadeAModifier = findStadeById(uuid);

		if(stadeAModifier != null) {
			stadeAModifier.setNom_stade(stade.getNom_stade());
			stadeAModifier.setAdresse_stade(stade.getAdresse_stade());
			stadeAModifier.setCapacite_stade(stade.getCapacite_stade());
			stadeAModifier.setEst_reserve(stade.getEst_reserve());
			repository.save(stadeAModifier);
			return true;
		}
		return false;
	}

	public boolean updatePartielle(String uuid, UpdateStade stade) {
		Stade stadeAModifier = findStadeById(uuid);

		if(stadeAModifier != null) {
			if(!stade.getNom_stade().isEmpty()) {
				stadeAModifier.setNom_stade(stade.getNom_stade());
                stadeAModifier.setAdresse_stade(stade.getAdresse_stade());
                stadeAModifier.setCapacite_stade(stade.getCapacite_stade());
                stadeAModifier.setEst_reserve(stade.getEst_reserve());
			}
			repository.save(stadeAModifier);
			return true;
		}
		return false;
	}
}
