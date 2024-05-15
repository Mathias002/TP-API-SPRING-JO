package fr.efrei.test.service;

import fr.efrei.test.dto.CreateBoutique;
import fr.efrei.test.dto.UpdateBoutique;
import fr.efrei.test.model.Boutique;
import fr.efrei.test.repository.BoutiqueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BoutiqueService {

	private final BoutiqueRepository repository;

	@Autowired
	public BoutiqueService(BoutiqueRepository repository) {
		this.repository = repository;
	}

	public List<Boutique> findAllBoutiques() {
		return repository.findAll();
	}

	public Boutique findBoutiqueById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}

	public Boutique create(CreateBoutique boutique) {
		// ici je suis dans la DTO
		//
		Boutique boutiqueACreer = new Boutique(
				boutique.getNom_boutique()
		);
		// je suis dans une entité
		return repository.save(boutiqueACreer);
	}

	@Transactional
	public boolean delete(String uuid) {
		Boutique boutiqueASupprimer = findBoutiqueById(uuid);
		if(boutiqueASupprimer != null ){
			repository.save(boutiqueASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String uuid, UpdateBoutique boutique) {
		Boutique boutiqueAModifier = findBoutiqueById(uuid);

		if(boutiqueAModifier != null) {
			boutiqueAModifier.setNom_boutique(boutique.getNom_boutique());
			repository.save(boutiqueAModifier);
			return true;
		}
		return false;
	}

	public boolean updatePartielle(String uuid, UpdateBoutique boutique) {
		Boutique boutiqueAModifier = findBoutiqueById(uuid);

		if(boutiqueAModifier != null) {
			if(!boutique.getNom_boutique().isEmpty()) {
				boutiqueAModifier.setNom_boutique(boutique.getNom_boutique());
			}
			repository.save(boutiqueAModifier);
			return true;
		}
		return false;
	}
}
