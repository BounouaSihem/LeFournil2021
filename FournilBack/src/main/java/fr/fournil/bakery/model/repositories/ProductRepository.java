package fr.fournil.bakery.model.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fournil.bakery.model.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findAll();	
	Optional<Product> findById(Long id);
	//List<Product> findAllOrderByFormatSetDesc();
	/*List<Product> findAllByOrderByIdAsc();
	List<Product> findAllAndForFormatSetOrderByIdAsc();
	List<Product> findAllByOrderByFormatSetOrderByIdAsc();
	List<Product> findAllByFormatSetOrderByIdAsc();
	//List<Product> findAllByOrderByFormatSet();
	List<Product> findAllAndFormatSetOrderByIdAsc();*/
}
