package fr.efrei.test.repository;

import fr.efrei.test.model.Epreuve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EpreuveRepository extends JpaRepository<Epreuve, String> {

	// SELECT * from Epreuve where deleted_at is null
	List<Epreuve> findAllByDeletedAtNull();

	// SELECT * FROM Epreuve where Uuid_epreuve = ?
	Optional<Epreuve> findOneByUuid(String Uuid_epreuve);

	Epreuve save(Epreuve epreuve);

	void deleteByUuid(String Uuid_epreuve);
}
