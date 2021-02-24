package fr.fournil.bakery.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fournil.bakery.model.entities.ShoppingCart;
import fr.fournil.bakery.model.repositories.CommandeRepository;
import fr.fournil.bakery.model.repositories.CustomerRepository;
import fr.fournil.bakery.model.repositories.ProductInCartRepository;
import fr.fournil.bakery.model.repositories.ProductRepository;
import fr.fournil.bakery.model.repositories.ShoppingCartRepository;

@Service(value = "ShoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {

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
	
	@Autowired
	private  ProductInCartService  productInCartService;
	
	@Autowired
	private  ProductInCartRepository  productInCartRepository;	
	
	
	
	@Autowired
	private  ShoppingCartRepository  shoppingCartRepository;	
	
	
	
	@Override
	public List<ShoppingCart> getShoppingCartList() {
		
		return shoppingCartRepository.findAll();
	}

	@Override
	public Optional<ShoppingCart> getShoppingCartById(Long id) {
		
		return shoppingCartRepository.findById(id);
	}

}
