package fr.efrei.test.repository;

import fr.efrei.test.model.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StadeRepository extends JpaRepository<Stade, String> {

	// SELECT * from Stade where deleted_at is null
	List<Stade> findAllByDeletedAtNull();

	// SELECT * FROM Stade where Uuid_stade = ?
	Optional<Stade> findOneByUuid(String Uuid_stade);

	Stade save(Stade stade);

	void deleteByUuid(String Uuid_stade);
}