package fr.fournil.bakery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.fournil.bakery.model.entities.FrequencyDeliveryType;
import fr.fournil.bakery.model.repositories.FrequenceDeliveryTypeRepository;
import fr.fournil.bakery.model.services.FrequencyDeliveryTypeService;

@CrossOrigin(origins = "*")
@RestController

@RequestMapping(value="/frequency_delivery_type")

public class FrequencyDeliveryTypeController {
	
	@Autowired
	private FrequencyDeliveryTypeService frequencyDeliveryTypeService;
	
	@Autowired
	private FrequenceDeliveryTypeRepository frequenceDeliveryTypeRepository;

	public FrequencyDeliveryTypeController(FrequencyDeliveryTypeService frequencyDeliveryTypeService,
			FrequenceDeliveryTypeRepository frequenceDeliveryTypeRepository) {
		super();
		this.frequencyDeliveryTypeService = frequencyDeliveryTypeService;
		this.frequenceDeliveryTypeRepository = frequenceDeliveryTypeRepository;
	}
	
	@GetMapping(value ="")
	public ResponseEntity<List<FrequencyDeliveryType>> getAllFrequenceDeliveryType() {
		List<FrequencyDeliveryType> listFrequenceDeliveryType = this.frequencyDeliveryTypeService.getFrequencyDeliveryTypeList();
		return new ResponseEntity<List<FrequencyDeliveryType>>(listFrequenceDeliveryType, HttpStatus.OK);
	}
	

	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FrequencyDeliveryType> getFrequenceDeliveryTypeById(@PathVariable(value = "id") Long id) {
		FrequencyDeliveryType frequenceDeliveryTypetById = this.frequencyDeliveryTypeService.getFrequencyDeliveryTypeById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune frequence avec l'id : " + id));
		return new ResponseEntity<FrequencyDeliveryType>(frequenceDeliveryTypetById, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
