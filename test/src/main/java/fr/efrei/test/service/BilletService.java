package fr.efrei.test.service;

import fr.efrei.test.dto.CreateBillet;
import fr.efrei.test.dto.UpdateBillet;
import fr.efrei.test.model.Billet;
import fr.efrei.test.model.Boutique;
import fr.efrei.test.model.Commande;
import fr.efrei.test.model.Epreuve;
import fr.efrei.test.model.Spectateur;
import fr.efrei.test.repository.BilletRepository;
import fr.efrei.test.repository.CommandeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BilletService {

	private final BilletRepository repository;
	private final BoutiqueService boutiqueService;
	private final EpreuveService epreuveService;
	private final CommandeService commandeService;

	@Autowired
	public BilletService(BilletRepository repository, CommandeService commandeService, BoutiqueService boutiqueService, EpreuveService epreuveService ) {
		this.repository = repository;
		this.commandeService = commandeService;
		this.boutiqueService = boutiqueService;
		this.epreuveService = epreuveService;
	}

	public List<Billet> findAllBillets() {
		return repository.findAll();
	}

	public Billet findBilletById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}

	public Billet create(CreateBillet billetData) {
		// ici je suis dans la DTO
		Commande commande = commandeService.findCommandeById(billetData.getCommande());
		Boutique boutique = boutiqueService.findBoutiqueById(billetData.getBoutique());
		Epreuve epreuve = epreuveService.findEpreuveById(billetData.getEpreuve());
		
		Billet billet = new Billet(billetData.getNom(), billetData.getPrix());
		billet.setCommande(commande);
		billet.setBoutique(boutique);
		billet.setEpreuve(epreuve);
		return repository.save(billet);
	}

	@Transactional
	public boolean delete(String uuid) {
		Billet billetASupprimer = findBilletById(uuid);
		if(billetASupprimer != null && billetASupprimer.getDeletedAt() == null){
			billetASupprimer.setDeletedAt(LocalDateTime.now());
			repository.save(billetASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String uuid, UpdateBillet billetData) {
		Billet billetAModifier = findBilletById(uuid);

		if(billetAModifier != null) {
			Commande commande = commandeService.findCommandeById(billetData.getCommande());
			Boutique boutique = boutiqueService.findBoutiqueById(billetData.getBoutique());
			Epreuve epreuve = epreuveService.findEpreuveById(billetData.getEpreuve());
			if (commande == null) {
                throw new EntityNotFoundException("Commande non trouvé avec l'UUID: " + billetData.getCommande());
            }else if(boutique == null){
				throw new EntityNotFoundException("Boutique non trouvé avec l'UUID: " + billetData.getBoutique());
			}else if(epreuve == null){
				throw new EntityNotFoundException("Epreuve non trouvé avec l'UUID: " + billetData.getEpreuve());
			}
			billetAModifier.setNom(billetData.getNom());
			billetAModifier.setPrix(billetData.getPrix());
			billetAModifier.setCommande(commande);
			billetAModifier.setBoutique(boutique);
			billetAModifier.setEpreuve(epreuve);
			repository.save(billetAModifier);
			return true;
		}
		return false;
	}

	public boolean updatePartielle(String uuid, UpdateBillet billetData) {
		Billet billetAModifier = findBilletById(uuid);

		if (billetAModifier != null) {
            if (billetData.getNom() != null && !billetData.getNom().isEmpty()) {
                billetAModifier.setNom(billetData.getNom());
            }
            if (billetData.getCommande() != null && !billetData.getCommande().isEmpty()) {
                Commande commande = commandeService.findCommandeById(billetData.getCommande());
                if (commande == null) {
                    throw new EntityNotFoundException("Commande non trouvé avec l'UUID: " + billetData.getCommande());
                }
                billetAModifier.setCommande(commande);
            }
            if (billetData.getBoutique() != null && !billetData.getBoutique().isEmpty()) {
                Boutique boutique = boutiqueService.findBoutiqueById(billetData.getBoutique());
                if (boutique == null) {
                    throw new EntityNotFoundException("Boutique non trouvé avec l'UUID: " + billetData.getBoutique());
                }
                billetAModifier.setBoutique(boutique);
            }
            if (billetData.getEpreuve() != null && !billetData.getEpreuve().isEmpty()) {
                Epreuve epreuve = epreuveService.findEpreuveById(billetData.getEpreuve());
                if (epreuve == null) {
                    throw new EntityNotFoundException("Epreuve non trouvé avec l'UUID: " + billetData.getEpreuve());
                }
                billetAModifier.setEpreuve(epreuve);
            }
            repository.save(billetAModifier);
            return true;
        }
		return false;
	}
}
