package fr.efrei.test.controller;

import fr.efrei.test.dto.CreateSpectateur;
import fr.efrei.test.dto.UpdateSpectateur;
import fr.efrei.test.model.Spectateur;
import fr.efrei.test.service.SpectateurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/spectateurs")
@EnableMethodSecurity
public class SpectateurController {

	private final SpectateurService service;

	@Autowired
	public SpectateurController(SpectateurService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Spectateur>> findAll() {
		return new ResponseEntity<>(service.findAllSpectateurs(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Spectateur> findOneById(@PathVariable String uuid) {
		Spectateur spectateur = service.findSpectateurById(uuid);
		if(spectateur != null) {
			return new ResponseEntity<>(service.findSpectateurById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// @PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping
	public ResponseEntity<Spectateur> save(@Valid @RequestBody CreateSpectateur spectateur) {
		Spectateur createdSpectateur = service.create(spectateur);
		return new ResponseEntity<>(createdSpectateur, HttpStatus.CREATED);
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
			@Valid @RequestBody UpdateSpectateur spectateur) {
		boolean isUpdated = service.update(uuid, spectateur);
		if(isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PatchMapping("/{uuid}")
	public ResponseEntity<?> mettreAjourPartiellement(
			@PathVariable String uuid,
			@Valid @RequestBody UpdateSpectateur spectateur) {
		boolean isUpdated = service.updatePartielle(uuid, spectateur);
		if(isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
