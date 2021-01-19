package fr.fournil.bakery.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fournil.bakery.model.entities.PhotoProduct;



@Repository
public interface PhotoProductRepository extends JpaRepository<PhotoProduct, Long>{
	List<PhotoProduct> findAll();
}
