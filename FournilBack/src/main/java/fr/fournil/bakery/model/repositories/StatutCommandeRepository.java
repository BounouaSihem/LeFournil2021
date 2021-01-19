package fr.fournil.bakery.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import fr.fournil.bakery.model.entities.StatutCommande;
import fr.fournil.bakery.model.entities.StatutName;


@Repository
public interface StatutCommandeRepository extends JpaRepository<StatutCommande,Long> {
	Optional<StatutCommande> findByStatutName(StatutName statutName);

}
