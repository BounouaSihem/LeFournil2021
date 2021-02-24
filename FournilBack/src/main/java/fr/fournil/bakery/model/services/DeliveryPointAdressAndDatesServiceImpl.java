package fr.fournil.bakery.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fournil.bakery.model.entities.DeliveryPointAdressAndDates;
import fr.fournil.bakery.model.repositories.DeliveryPointAdressAndDatesRepository;

@Service(value = "DeliveryPointAdressAndDatesService")
public class DeliveryPointAdressAndDatesServiceImpl implements DeliveryPointAdressAndDatesService {

	@Autowired
	private DeliveryPointAdressAndDatesRepository deliveryPointAdressAndDates;
	
	
	@Override
	public List<DeliveryPointAdressAndDates> getDeliveryPointAdressAndDatesList() {
		// TODO Auto-generated method stub
		return deliveryPointAdressAndDates.findAll();
	}

	@Override
	public Optional<DeliveryPointAdressAndDates> getDeliveryPointAdressAndDatesById(Long id) {
		// TODO Auto-generated method stub
		return deliveryPointAdressAndDates.findById(id);
	}

}
