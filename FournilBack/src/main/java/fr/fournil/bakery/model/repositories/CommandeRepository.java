package fr.fournil.bakery.model.repositories;

import java.util.List;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fournil.bakery.model.entities.Commande;




@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
	List<Commande> findAll();
	Optional<Commande> findById(Long id);

}