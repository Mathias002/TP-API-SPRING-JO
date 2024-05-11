package fr.efrei.test.repository;

import fr.efrei.test.model.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StadeRepository extends JpaRepository<Stade, String> {

	// SELECT * FROM Stade where uuid = ?
	Optional<Stade> findOneByUuid(String uuid);

	Stade save(Stade stade);

	void deleteByUuid(String uuid);
}