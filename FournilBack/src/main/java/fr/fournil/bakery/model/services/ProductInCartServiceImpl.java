package fr.fournil.bakery.model.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import fr.fournil.bakery.model.entities.Format;
import fr.fournil.bakery.model.entities.FrequencyDeliveryType;
import fr.fournil.bakery.model.entities.PhotoProduct;
import fr.fournil.bakery.model.entities.Product;
import fr.fournil.bakery.model.entities.ProductForm;
import fr.fournil.bakery.model.entities.ProductInCart;
import fr.fournil.bakery.model.entities.ShoppingCart;
import fr.fournil.bakery.model.repositories.CommandeRepository;
import fr.fournil.bakery.model.repositories.CustomerRepository;
import fr.fournil.bakery.model.repositories.FormatRepository;
import fr.fournil.bakery.model.repositories.FrequenceDeliveryTypeRepository;
import fr.fournil.bakery.model.repositories.ProductInCartRepository;
import fr.fournil.bakery.model.repositories.ProductRepository;
import fr.fournil.bakery.model.repositories.ShoppingCartRepository;


@Service(value = "ProductInCartService")
public class ProductInCartServiceImpl  implements ProductInCartService{
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
	private FormatRepository formatRepository;
	@Autowired
	private FrequenceDeliveryTypeRepository frequenceDeliveryTypeRepository;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	private ProductForm productForm;
	
	@Override
	public List<ProductInCart> getProductInCartList() {
		// TODO Auto-generated method stub
		return productInCartRepository.findAll();
	}

	@Override
	public Optional<ProductInCart> getProductInCartById(Long id) {
		// TODO Auto-generated method stub
		return productInCartRepository.findById(id);
	}
	

	@Override
	public Optional<ProductInCart> addAndSaveProductInCart(Long idProduct ,ProductForm productForm) {
		//idProduct=productForm.getProductId();
		 this.productRepository.findById(idProduct);
		
		Format oneFormat=  this.formatRepository.findByFormatType(productForm.getFormatChoosen());
		FrequencyDeliveryType frenquencyType=frequenceDeliveryTypeRepository.findByFrequencyCommandeProduct(productForm.getFrequencyCommandeProduct());
		Product oneProduct=this.productRepository.findById(idProduct).get();
		
		oneProduct.setId(idProduct);
		oneProduct.setProductName(oneProduct.getProductName());
		ProductInCart productToAdd=new ProductInCart();
		ShoppingCart oneShoppingCart= new ShoppingCart();
		Long idCart = oneShoppingCart.getId();
		
		//ProductInCart productToAdd=productInCartRepository.findByProductId(idProduct);
		productToAdd.setId(oneProduct.getId());
		 System.out.println("productToAdd.getId()" + oneProduct.getId());
		productToAdd.setProduct(oneProduct);
		productToAdd.setFrequencyDeliveryType( frenquencyType);
		productToAdd.setQuantity(productForm.getQuantity());
		productToAdd.setFormat(oneFormat);
		productToAdd.setShoppingCart(productToAdd.getShoppingCart());
		productToAdd.setTotalPricePerProduct(productToAdd.getTotalPricePerProduct());//calculé directement enforçant le constructeur
		productToAdd=this.productInCartRepository.save(productToAdd);
		 System.out.println("productTotalPrice=" + productToAdd.getTotalPricePerProduct());
		 Set<ProductInCart> productInCartSet = oneShoppingCart.getProductInCartSet();
		 productInCartSet.add(productToAdd);
		 oneShoppingCart.setId(oneShoppingCart.getId());
		 oneShoppingCart.setProductInCartSet(productInCartSet);
		 oneShoppingCart.setTotalPriceInCart(oneShoppingCart.getTotalPriceInCart());
		 oneShoppingCart.setCommande(oneShoppingCart.getCommande());
		 //shoppingCartRepository.save(oneShoppingCart);
		// ShoppingCartRepository.save(productInCartSet);
		return Optional.of(productToAdd);
	}

	@Override
	public void deleteOneProductIncart(Long shoppingCartId,Long id) {
		ShoppingCart oneShoppingCart=shoppingCartRepository.findById(shoppingCartId).get();
		ProductInCart productToDelete= productInCartRepository.findById(id).get();
		
		
		Set<ProductInCart> listProducts=oneShoppingCart.getProductInCartSet();
		
		if (listProducts.contains(productToDelete)) {
			listProducts.remove(productToDelete);
			oneShoppingCart.setProductInCartSet(listProducts);
			shoppingCartRepository.save(oneShoppingCart);
		}
		//productInCartRepository.deleteById(id);
		
	}

	@Override
	public Optional<ProductInCart> editAndSaveProductInCart(Long shoppingCartId,Long idProduct, ProductForm productForm) {
		Optional<ShoppingCart> oneShoppingCart=shoppingCartRepository.findById(shoppingCartId);
		ProductInCart productToModify= productInCartRepository.findById(idProduct).get();
		Format oneFormat=  this.formatRepository.findByFormatType(productForm.getFormatChoosen());
		FrequencyDeliveryType frenquencyType=frequenceDeliveryTypeRepository.findByFrequencyCommandeProduct(productForm.getFrequencyCommandeProduct());
		
		Set<ProductInCart> productList=oneShoppingCart.get().getProductInCartSet();
		if(productList.contains(productToModify)) {
			productToModify.setFrequencyDeliveryType( frenquencyType);
			productToModify.setQuantity(productForm.getQuantity());
			productToModify.setFormat(oneFormat);
			productToModify=this.productInCartRepository.save(productToModify);
			
		}
		
		return Optional.of(productToModify);
		
	}

	

	
	
	
//////////////////////////////////////////////////////////	
}
