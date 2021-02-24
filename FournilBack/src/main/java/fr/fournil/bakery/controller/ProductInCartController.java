package fr.fournil.bakery.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.fournil.bakery.model.entities.Product;
import fr.fournil.bakery.model.entities.ProductForm;
import fr.fournil.bakery.model.entities.ProductInCart;
import fr.fournil.bakery.model.repositories.CommandeRepository;
import fr.fournil.bakery.model.repositories.CustomerRepository;
import fr.fournil.bakery.model.repositories.ProductInCartRepository;
import fr.fournil.bakery.model.repositories.ProductRepository;
import fr.fournil.bakery.model.services.CommandeService;
import fr.fournil.bakery.model.services.CustomerService;
import fr.fournil.bakery.model.services.ProductInCartService;
import fr.fournil.bakery.model.services.ProductService;

@CrossOrigin(origins = "*")
@RestController

@RequestMapping(value = "/productsinCart")
public class ProductInCartController {
	
	
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

	
	

	public ProductInCartController(CustomerService customerService, CustomerRepository customerRepository,
			ProductService productService, ProductRepository productRepository, CommandeService commandeService,
			CommandeRepository commandeRepository, ProductInCartService productInCartService,
			ProductInCartRepository productInCartRepository) {
		super();
		this.customerService = customerService;
		this.customerRepository = customerRepository;
		this.productService = productService;
		this.productRepository = productRepository;
		this.commandeService = commandeService;
		this.commandeRepository = commandeRepository;
		this.productInCartService = productInCartService;
		this.productInCartRepository = productInCartRepository;
	}




	@GetMapping(value = "")
	public ResponseEntity<List<ProductInCart>> getAllProductInCart() {
		List<ProductInCart> listProducts = this.productInCartService.getProductInCartList();
		return new ResponseEntity<List<ProductInCart>>(listProducts, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductInCart> getProductInCartById(@PathVariable(value = "id") Long id) {
		ProductInCart ProductInCartById = this.productInCartService.getProductInCartById(id).get();
				
				if (!this.productInCartService.getProductInCartById(id).isPresent()) {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun produit trouvé avec l'id :" + id);
				} else

		return new ResponseEntity<ProductInCart>(ProductInCartById, HttpStatus.OK);
	}
	// ajouter un produit dans le panier
	@PostMapping(value="/add_product/{id}")
	public ResponseEntity <ProductInCart>addProductInCart(@PathVariable(value = "id") Long id , @Valid @RequestBody ProductForm productForm) {
		id=productForm.getProductId();
		ProductInCart productSelected=this.productInCartService.addAndSaveProductInCart(id,productForm).get();
		if (!this.productInCartService.addAndSaveProductInCart(id,productForm).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun produit trouvé avec l'id :" + id);
		} else
		
		return new ResponseEntity<ProductInCart>( productSelected, HttpStatus.OK);
		}
//////////////
}
