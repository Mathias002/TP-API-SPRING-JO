package fr.efrei.test.repository;

import fr.efrei.test.model.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoutiqueRepository extends JpaRepository<Boutique, String> {

	// SELECT * FROM Boutique 
	List<Boutique>  findAll();

	// SELECT * FROM Boutique where uuid = ?
	Optional<Boutique> findOneByUuid(String uuid);

	Boutique save(Boutique boutique);

	void delete(Boutique boutique);
}
