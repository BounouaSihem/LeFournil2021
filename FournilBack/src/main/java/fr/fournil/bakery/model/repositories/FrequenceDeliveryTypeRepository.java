package fr.fournil.bakery.model.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import fr.fournil.bakery.model.entities.FrequencyDeliveryType;
import fr.fournil.bakery.model.entities.Product;


@Repository
public interface FrequenceDeliveryTypeRepository extends JpaRepository<FrequencyDeliveryType, Long> {
	List<FrequencyDeliveryType> findAll();
	Optional<FrequencyDeliveryType> findById(Long id);
}
