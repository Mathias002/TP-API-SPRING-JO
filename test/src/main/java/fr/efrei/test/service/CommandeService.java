package fr.efrei.test.service;


import fr.efrei.test.dto.CreateCommande;
import fr.efrei.test.dto.UpdateCommande;
import fr.efrei.test.model.Billet;
import fr.efrei.test.model.Commande;
import fr.efrei.test.model.Spectateur;
import fr.efrei.test.repository.CommandeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommandeService {

	private final CommandeRepository repository;
	private final SpectateurService spectateurService;

	@Autowired
	public CommandeService(CommandeRepository repository, SpectateurService spectateurService) {
		this.repository = repository;
		this.spectateurService = spectateurService;
	}

	public List<Commande> findAllCommandes() {
		return repository.findAll();
	}

	public Commande findCommandeById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}

	public Commande create(CreateCommande commandedata) {
		// ici je suis dans la DTO
		System.out.println(commandedata.getSpectateur());
		Spectateur spectateur = spectateurService.findSpectateurById(commandedata.getSpectateur());
		Commande commande = new Commande(commandedata.getNom());
		commande.setSpectateur(spectateur);
		return repository.save(commande);
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
			commandeAModifier.setSpectateur(commande.getSpectateur());
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
				commandeAModifier.setSpectateur(commande.getSpectateur());
			}
			repository.save(commandeAModifier);
			return true;
		}
		return false;
	}
}
