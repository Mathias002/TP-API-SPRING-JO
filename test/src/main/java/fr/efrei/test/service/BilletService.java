package fr.efrei.test.service;

import fr.efrei.test.dto.CreateBillet;
import fr.efrei.test.dto.UpdateBillet;
import fr.efrei.test.model.Billet;
import fr.efrei.test.repository.BilletRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BilletService {

	private final BilletRepository repository;

	@Autowired
	public BilletService(BilletRepository repository) {
		this.repository = repository;
	}

	public List<Billet> findAllBillets() {
		return repository.findAll();
	}

	public Billet findBilletById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}

	public Billet create(CreateBillet billet) {
		// ici je suis dans la DTO
		//
		Billet billetACreer = new Billet(
				billet.getNom(),
				billet.getPrix(),
				billet.getBoutique(),
				billet.getCommande(),
				billet.getEpreuve(),
				billet.getSpectateur()
		);
		// je suis dans une entité
		return repository.save(billetACreer);
	}

	@Transactional
	public boolean delete(String uuid) {
		Billet billetASupprimer = findBilletById(uuid);
		if(billetASupprimer != null ){
			repository.delete(billetASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String uuid, UpdateBillet billet) {
		Billet billetAModifier = findBilletById(uuid);

		if(billetAModifier != null) {
			billetAModifier.setNom(billet.getNom());
			billetAModifier.setPrix(billet.getPrix());
			billetAModifier.setIsValid(billet.isIsValid());
			billetAModifier.setBoutique(billet.getBoutique());
			billetAModifier.setCommande(billet.getCommande());
			billetAModifier.setEpreuve(billet.getEpreuve());
			billetAModifier.setSpectateur(billet.getSpectateur());
			repository.save(billetAModifier);
			return true;
		}
		return false;
	}

	public boolean updatePartielle(String uuid, UpdateBillet billet) {
		Billet billetAModifier = findBilletById(uuid);

		if(billetAModifier != null) {
			if(!billet.getNom().isEmpty()) {
				billetAModifier.setNom(billet.getNom());
                billetAModifier.setPrix(billet.getPrix());
                billetAModifier.setIsValid(billet.isIsValid());
                billetAModifier.setBoutique(billet.getBoutique());
                billetAModifier.setCommande(billet.getCommande());
                billetAModifier.setEpreuve(billet.getEpreuve());
                billetAModifier.setSpectateur(billet.getSpectateur());
			}
			repository.save(billetAModifier);
			return true;
		}
		return false;
	}
}
