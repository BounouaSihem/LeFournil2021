package fr.fournil.bakery.model.services;

import java.util.List;
import java.util.Optional;

import fr.fournil.bakery.model.entities.FrequencyDeliveryType;
import fr.fournil.bakery.model.entities.Product;

public interface FrequencyDeliveryTypeService {
	List <FrequencyDeliveryType> getFrequencyDeliveryTypeList();
	Optional<FrequencyDeliveryType> getFrequencyDeliveryTypeById(Long id);

}
