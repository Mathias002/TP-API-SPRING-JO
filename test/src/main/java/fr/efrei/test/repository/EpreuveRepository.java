package fr.efrei.test.repository;

import fr.efrei.test.model.Epreuve;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EpreuveRepository extends JpaRepository<Epreuve, String> {

	List<Epreuve>  findAll();

	// SELECT * FROM Epreuve where uuid = ?
	Optional<Epreuve> findOneByUuid(String uuid);

	// SELECT uuid FROM stade JOIN heberge ON stade.uuid = heberge.stade_uuid JOIN epreuve ON epreuve.uuid = heberge.epreuve_uuid WHERE epreuve.uuid = ?"
    List<String> findStadeUuidsByEpreuveUuid(String uuid);

	Epreuve save(Epreuve epreuve);

	void deleteByUuid(String uuid);
}
