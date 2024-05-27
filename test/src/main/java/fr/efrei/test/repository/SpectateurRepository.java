package fr.efrei.test.repository;

import fr.efrei.test.model.Spectateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface SpectateurRepository extends JpaRepository<Spectateur, String> {

	// SELECT * from Spectateur where deleted_at is null
	List<Spectateur> findAllByDeletedAtNull();

	// SELECT * FROM Spectateur where uuid = ?
	Optional<Spectateur> findOneByUuid(String uuid);

	Spectateur save(Spectateur spectateur);

	void deleteByUuid(String uuid);
}
