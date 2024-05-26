package fr.efrei.test.service;


import fr.efrei.test.dto.CreateCommande;
import fr.efrei.test.dto.UpdateCommande;
import fr.efrei.test.model.Commande;
import fr.efrei.test.model.Spectateur;
import fr.efrei.test.repository.CommandeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

	public Commande create(CreateCommande commandeData) {
		// ici je suis dans la DTO
		Spectateur spectateur = spectateurService.findSpectateurById(commandeData.getSpectateur());
		Commande commande = new Commande(commandeData.getNom());
		commande.setSpectateur(spectateur);
		return repository.save(commande);
	}

	@Transactional
	public boolean delete(String uuid) {
		Commande commandeASupprimer = findCommandeById(uuid);
		if(commandeASupprimer != null && commandeASupprimer.getDeletedAt() == null){
			commandeASupprimer.setDeletedAt(LocalDateTime.now());
			repository.save(commandeASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String uuid, UpdateCommande commandeData) {
        Commande commandeAModifier = findCommandeById(uuid);

        if (commandeAModifier != null) {
            Spectateur spectateur = spectateurService.findSpectateurById(commandeData.getSpectateur());
            if (spectateur == null) {
                throw new EntityNotFoundException("Spectateur non trouvé avec l'UUID: " + commandeData.getSpectateur());
            }
            commandeAModifier.setNom(commandeData.getNom());
            commandeAModifier.setSpectateur(spectateur);
            repository.save(commandeAModifier);
            return true;
        }
        return false;
    }

	public boolean updatePartielle(String uuid, UpdateCommande commandeData) {
        Commande commandeAModifier = findCommandeById(uuid);

        if (commandeAModifier != null) {
            if (commandeData.getNom() != null && !commandeData.getNom().isEmpty()) {
                commandeAModifier.setNom(commandeData.getNom());
            }
            if (commandeData.getSpectateur() != null && !commandeData.getSpectateur().isEmpty()) {
                Spectateur spectateur = spectateurService.findSpectateurById(commandeData.getSpectateur());
                if (spectateur == null) {
                    throw new EntityNotFoundException("Spectateur non trouvé avec l'UUID: " + commandeData.getSpectateur());
                }
                commandeAModifier.setSpectateur(spectateur);
            }
            repository.save(commandeAModifier);
            return true;
        }
        return false;
    }
}
