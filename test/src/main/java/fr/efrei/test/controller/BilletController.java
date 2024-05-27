package fr.efrei.test.controller;

import fr.efrei.test.dto.CreateBillet;
import fr.efrei.test.dto.UpdateBillet;
import fr.efrei.test.service.BilletService;
import fr.efrei.test.model.Billet;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/billets")
@EnableMethodSecurity
public class BilletController {

	private final BilletService service;

	@Autowired
	public BilletController(BilletService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Billet>> findAll() {
		return new ResponseEntity<>(service.findAllBillets(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Billet> findOneById(@PathVariable String uuid) {
		Billet billet = service.findBilletById(uuid);
		if(billet != null) {
			return new ResponseEntity<>(service.findBilletById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// @PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping
	public ResponseEntity<Billet> save(@Valid @RequestBody CreateBillet billet) {
		Billet createdBillet = service.create(billet);
		System.out.println("test");
		return new ResponseEntity<>(createdBillet, HttpStatus.CREATED);
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
			@Valid @RequestBody UpdateBillet billet) {
		boolean isUpdated = service.update(uuid, billet);
		if(isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PatchMapping("/{uuid}")
	public ResponseEntity<?> mettreAjourPartiellement(
			@PathVariable String uuid,
			@Valid @RequestBody UpdateBillet billet) {
		boolean isUpdated = service.updatePartielle(uuid, billet);
		if(isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
