package fr.efrei.test;

import fr.efrei.test.model.Spectateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpectatorRepository extends CrudRepository<Spectateur, Integer> {
	Optional<Spectateur> findByEmail(String email);
}