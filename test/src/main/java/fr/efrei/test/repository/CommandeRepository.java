package fr.efrei.test.repository;

import fr.efrei.test.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, String> {

	// SELECT * from Commande where deleted_at is null
	List<Commande> findAllByDeletedAtNull();

	// SELECT * FROM Commande where Uuid_commande = ?
	Optional<Commande> findOneByUuid(String Uuid_commande);

	Commande save(Commande commande);

	void deleteByUuid(String Uuid_commande);
}
