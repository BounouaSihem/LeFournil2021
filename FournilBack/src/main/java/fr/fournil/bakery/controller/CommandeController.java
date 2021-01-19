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

import fr.fournil.bakery.model.entities.Commande;
import fr.fournil.bakery.model.entities.Product;
import fr.fournil.bakery.model.repositories.CommandeRepository;
import fr.fournil.bakery.model.repositories.CustomerRepository;
import fr.fournil.bakery.model.repositories.ProductRepository;
import fr.fournil.bakery.model.services.CommandeService;
import fr.fournil.bakery.model.services.CustomerService;
import fr.fournil.bakery.model.services.ProductService;

@CrossOrigin(origins = "*")
@RestController

@RequestMapping(value="/commandes")
public class CommandeController {
	   
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CommandeService commandeService;
	
	@Autowired
	private CommandeRepository commandeRepository;

	public CommandeController(CustomerService customerService, CustomerRepository customerRepository,
			ProductService productService, ProductRepository productRepository, CommandeService commandeService,
			CommandeRepository commandeRepository) {
		super();
		this.customerService = customerService;
		this.customerRepository = customerRepository;
		this.productService = productService;
		this.productRepository = productRepository;
		this.commandeService = commandeService;
		this.commandeRepository = commandeRepository;
	}
	
	
	@GetMapping(value ="")
	public ResponseEntity<List<Commande>> getAllCommande() {
		List<Commande> listCommandes = this.commandeService.getCommandeList();
		return new ResponseEntity<List<Commande>>(listCommandes, HttpStatus.OK);
	}

	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Commande> getCommandeById(@PathVariable(value = "id") Long id) {
		Commande commandeById = this.commandeService.getCommandeById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune commande trouvée avec l'id : " + id));
		return new ResponseEntity<Commande>(commandeById, HttpStatus.OK);
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
