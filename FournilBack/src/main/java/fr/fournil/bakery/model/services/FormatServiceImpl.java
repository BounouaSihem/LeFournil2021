package fr.fournil.bakery.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fournil.bakery.model.entities.Format;
import fr.fournil.bakery.model.repositories.FormatRepository;
@Service(value = "formatService")
public class FormatServiceImpl implements FormatService  {
	@Autowired
	private FormatRepository formatRepository;
	@Override
	public List<Format> getFormatList() {
		
		return formatRepository.findAll();

}
}