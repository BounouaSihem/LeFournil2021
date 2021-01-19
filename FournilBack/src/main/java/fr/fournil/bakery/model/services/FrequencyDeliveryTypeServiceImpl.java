package fr.fournil.bakery.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fournil.bakery.model.entities.FrequencyDeliveryType;
import fr.fournil.bakery.model.repositories.FrequenceDeliveryTypeRepository;

@Service(value = "FrequencyDeliveryTypeService")
public class FrequencyDeliveryTypeServiceImpl implements FrequencyDeliveryTypeService {

	@Autowired
	private FrequencyDeliveryTypeService frequencyDeliveryTypeService;
	
	@Autowired
	private FrequenceDeliveryTypeRepository frequenceDeliveryTypeRepository;

	@Override
	public List<FrequencyDeliveryType> getFrequencyDeliveryTypeList() {
		
		return frequenceDeliveryTypeRepository.findAll();
	}

	@Override
	public Optional<FrequencyDeliveryType> getFrequencyDeliveryTypeById(Long id) {
		
		return frequenceDeliveryTypeRepository.findById(id);
	}
}
