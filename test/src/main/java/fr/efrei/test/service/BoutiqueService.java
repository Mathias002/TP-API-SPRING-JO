package fr.efrei.test.service;

import fr.efrei.test.dto.CreateBoutique;
import fr.efrei.test.dto.UpdateBoutique;
import fr.efrei.test.model.Boutique;
import fr.efrei.test.repository.BoutiqueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
				boutique.getNomBoutique()
		);
		// je suis dans une entité
		return repository.save(boutiqueACreer);
	}

	@Transactional
	public boolean delete(String uuid) {
		Boutique boutiqueASupprimer = findBoutiqueById(uuid);
		if(boutiqueASupprimer != null ){
			repository.delete(boutiqueASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String uuid, UpdateBoutique boutique) {
		Boutique boutiqueAModifier = findBoutiqueById(uuid);

		if(boutiqueAModifier != null) {
			boutiqueAModifier.setNomBoutique(boutique.getNomBoutique());
			repository.save(boutiqueAModifier);
			return true;
		}
		return false;
	}

	public boolean updatePartielle(String uuid, UpdateBoutique boutique) {
		Boutique boutiqueAModifier = findBoutiqueById(uuid);

		if(boutiqueAModifier != null) {
			if(!boutique.getNomBoutique().isEmpty()) {
				boutiqueAModifier.setNomBoutique(boutique.getNomBoutique());
			}
			repository.save(boutiqueAModifier);
			return true;
		}
		return false;
	}
}
