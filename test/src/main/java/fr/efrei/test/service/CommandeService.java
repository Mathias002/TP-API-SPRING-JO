package fr.efrei.test.service;

import fr.efrei.test.dto.CreateCommande;
import fr.efrei.test.dto.UpdateCommande;
import fr.efrei.test.model.Commande;
import fr.efrei.test.repository.CommandeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommandeService {

	private final CommandeRepository repository;

	@Autowired
	public CommandeService(CommandeRepository repository) {
		this.repository = repository;
	}

	public List<Commande> findAllCommandes() {
		return repository.findAll();
	}

	public Commande findCommandeById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}

	public Commande create(CreateCommande commande) {
		// ici je suis dans la DTO
		//
		Commande commandeACreer = new Commande(
				commande.getNom(),
				commande.getBillets()
		);
		// je suis dans une entité
		return repository.save(commandeACreer);
	}

	@Transactional
	public boolean delete(String uuid) {
		Commande commandeASupprimer = findCommandeById(uuid);
		if(commandeASupprimer != null ){
			repository.save(commandeASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String uuid, UpdateCommande commande) {
		Commande commandeAModifier = findCommandeById(uuid);

		if(commandeAModifier != null) {
			commandeAModifier.setNom(commande.getNom());
			repository.save(commandeAModifier);
			return true;
		}
		return false;
	}

	public boolean updatePartielle(String uuid, UpdateCommande commande) {
		Commande commandeAModifier = findCommandeById(uuid);

		if(commandeAModifier != null) {
			if(!commande.getNom().isEmpty()) {
				commandeAModifier.setNom(commande.getNom());
			}
			repository.save(commandeAModifier);
			return true;
		}
		return false;
	}
}
