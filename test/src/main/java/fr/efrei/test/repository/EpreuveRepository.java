package fr.efrei.test.repository;

import fr.efrei.test.model.Epreuve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EpreuveRepository extends JpaRepository<Epreuve, String> {

	// SELECT * FROM Epreuve where uuid = ?
	Optional<Epreuve> findOneByUuid(String uuid);

	Epreuve save(Epreuve epreuve);

	void deleteByUuid(String uuid);
}
