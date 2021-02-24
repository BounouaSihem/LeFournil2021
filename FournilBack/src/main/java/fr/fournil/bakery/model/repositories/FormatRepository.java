package fr.fournil.bakery.model.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fournil.bakery.model.entities.Format;

@Repository
public interface FormatRepository extends JpaRepository<Format, Long>{
	List<Format> findAll();
    Format findByProductListId(Long Id);
	//List<Format> findByProductList(Long id);
	Format findByFormatType(String formatChoosen);
}
