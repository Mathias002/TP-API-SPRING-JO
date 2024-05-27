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
				stade.getNomStade(),
				stade.getAdresseStade(),
				stade.getCapaciteStade()
		);
		// je suis dans une entité
		return repository.save(stadeACreer);
	}

	@Transactional
	public boolean delete(String uuid) {
		Stade stadeASupprimer = findStadeById(uuid);
		if(stadeASupprimer != null ){
			repository.delete(stadeASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String uuid, UpdateStade stade) {
		Stade stadeAModifier = findStadeById(uuid);

		if(stadeAModifier != null) {
			stadeAModifier.setNomStade(stade.getNomStade());
			stadeAModifier.setAdresseStade(stade.getAdresseStade());
			stadeAModifier.setCapaciteStade(stade.getCapaciteStade());
			stadeAModifier.setEstReserve(stade.isEstReserve());
			repository.save(stadeAModifier);
			return true;
		}
		return false;
	}

	public boolean updatePartielle(String uuid, UpdateStade stade) {
		Stade stadeAModifier = findStadeById(uuid);

		if(stadeAModifier != null) {
			if(!stade.getNomStade().isEmpty()) {
				stadeAModifier.setNomStade(stade.getNomStade());
                stadeAModifier.setAdresseStade(stade.getAdresseStade());
                stadeAModifier.setCapaciteStade(stade.getCapaciteStade());
                stadeAModifier.setEstReserve(stade.isEstReserve());
			}
			repository.save(stadeAModifier);
			return true;
		}
		return false;
	}
}
