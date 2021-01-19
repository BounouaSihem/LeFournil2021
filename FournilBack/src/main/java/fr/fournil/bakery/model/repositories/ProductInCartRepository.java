package fr.fournil.bakery.model.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fournil.bakery.model.entities.ProductInCart;



@Repository
public interface ProductInCartRepository extends JpaRepository<ProductInCart, Long>{
	List<ProductInCart> findAll();
	Optional<ProductInCart> findById(Long id);
}
