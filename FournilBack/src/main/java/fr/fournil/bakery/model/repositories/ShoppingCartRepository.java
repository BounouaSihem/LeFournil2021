package fr.fournil.bakery.model.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import fr.fournil.bakery.model.entities.ShoppingCart;


@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long>{
	List<ShoppingCart> findAll();
	Optional<ShoppingCart> findById(Long id);
}
