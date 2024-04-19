package fr.efrei.test.repository;

import fr.efrei.test.model.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoutiqueRepository extends JpaRepository<Boutique, String> {

	// SELECT * from Boutique where deleted_at is null
	List<Boutique> findAllByDeletedAtNull();

	// SELECT * FROM Boutique where Uuid_epreuve = ?
	Optional<Boutique> findOneByUuid(String Uuid_epreuve);

	Boutique save(Boutique epreuve);

	void deleteByUuid(String Uuid_epreuve);
}
