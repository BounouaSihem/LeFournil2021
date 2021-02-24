package fr.fournil.bakery.model.services;

import java.util.List;
import java.util.Optional;

import fr.fournil.bakery.model.entities.DeliveryPointAdressAndDates;


public interface DeliveryPointAdressAndDatesService {
	List <DeliveryPointAdressAndDates> getDeliveryPointAdressAndDatesList();
	Optional<DeliveryPointAdressAndDates> getDeliveryPointAdressAndDatesById(Long id);

}
