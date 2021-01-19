package fr.fournil.bakery.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fournil.bakery.model.entities.Product;
import fr.fournil.bakery.model.repositories.CommandeRepository;
import fr.fournil.bakery.model.repositories.CustomerRepository;
import fr.fournil.bakery.model.repositories.ProductRepository;


@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

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

	@Override
	public List<Product> getProductList() {
		
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductsById(Long id) {
		
		return productRepository.findById(id);
	}
	
	
	
////////////////////
}
