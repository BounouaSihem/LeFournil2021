package fr.fournil.bakery.model.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fournil.bakery.model.entities.DeliveryPointAdressAndDates;


@Repository
public interface DeliveryPointAdressAndDatesRepository extends JpaRepository <DeliveryPointAdressAndDates, Long> {
	List<DeliveryPointAdressAndDates> findAll();
	Optional<DeliveryPointAdressAndDates> findById(Long id);
}
