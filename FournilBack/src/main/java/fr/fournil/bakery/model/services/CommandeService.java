package fr.fournil.bakery.model.services;


import java.util.List;
import java.util.Optional;

import fr.fournil.bakery.model.entities.Commande;



public interface CommandeService {
	List <Commande> getCommandeList();
	Optional<Commande> getCommandeById(Long id);


}
