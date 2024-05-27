package fr.efrei.test.controller;

import fr.efrei.test.dto.CreateBoutique;
import fr.efrei.test.dto.UpdateBoutique;
import fr.efrei.test.service.BoutiqueService;
import fr.efrei.test.model.Boutique;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/boutiques")
@EnableMethodSecurity
public class BoutiqueController {

	private final BoutiqueService service;

	@Autowired
	public BoutiqueController(BoutiqueService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Boutique>> findAll() {
		return new ResponseEntity<>(service.findAllBoutiques(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Boutique> findOneById(@PathVariable String uuid) {
		Boutique boutique = service.findBoutiqueById(uuid);
		if(boutique != null) {
			return new ResponseEntity<>(service.findBoutiqueById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// @PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping
	public ResponseEntity<Boutique> save(@Valid @RequestBody CreateBoutique boutique) {
		Boutique createdBoutique = service.create(boutique);
		System.out.println("test");
		return new ResponseEntity<>(createdBoutique, HttpStatus.CREATED);
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
			@Valid @RequestBody UpdateBoutique boutique) {
		boolean isUpdated = service.update(uuid, boutique);
		if(isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PatchMapping("/{uuid}")
	public ResponseEntity<?> mettreAjourPartiellement(
			@PathVariable String uuid,
			@Valid @RequestBody UpdateBoutique boutique) {
		boolean isUpdated = service.updatePartielle(uuid, boutique);
		if(isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
