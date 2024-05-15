package fr.efrei.test.controller;

import fr.efrei.test.dto.CreateCommande;
import fr.efrei.test.dto.UpdateCommande;
import fr.efrei.test.service.CommandeService;
import fr.efrei.test.model.Commande;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/commandes")
@EnableMethodSecurity
public class CommandeController {

	private final CommandeService service;

	@Autowired
	public CommandeController(CommandeService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Commande>> findAllByDeletedAtNull() {
		return new ResponseEntity<>(service.findAllCommandes(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Commande> findOneById(@PathVariable String uuid) {
		Commande commande = service.findCommandeById(uuid);
		if(commande != null) {
			return new ResponseEntity<>(service.findCommandeById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping
	public ResponseEntity<Commande> save(@Valid @RequestBody CreateCommande commande) {
		Commande createdCommande = service.create(commande);
		return new ResponseEntity<>(createdCommande, HttpStatus.CREATED);
	}

	@DeleteMapping("/{uuid}")
	public ResponseEntity<?> delete(@PathVariable String uuid) {
		boolean isDeleted = service.delete(uuid);
		if(isDeleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{uuid}")
	public ResponseEntity<?> mettreAJourTotalement(
			@PathVariable String uuid,
			@RequestBody UpdateCommande commande) {
		boolean isUpdated = service.update(uuid, commande);
		if(isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PatchMapping("/{uuid}")
	public ResponseEntity<?> mettreAjourPartiellement(
			@PathVariable String uuid,
			@RequestBody UpdateCommande commande) {
		boolean isUpdated = service.updatePartielle(uuid, commande);
		if(isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
