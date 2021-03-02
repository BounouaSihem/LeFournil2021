package fr.fournil.bakery.model.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fournil.bakery.model.entities.Format;
import fr.fournil.bakery.model.entities.FrequencyDeliveryType;
import fr.fournil.bakery.model.entities.PhotoProduct;
import fr.fournil.bakery.model.entities.Product;
import fr.fournil.bakery.model.entities.ProductForm;
import fr.fournil.bakery.model.entities.ProductInCart;
import fr.fournil.bakery.model.repositories.CommandeRepository;
import fr.fournil.bakery.model.repositories.CustomerRepository;
import fr.fournil.bakery.model.repositories.FormatRepository;
import fr.fournil.bakery.model.repositories.FrequenceDeliveryTypeRepository;
import fr.fournil.bakery.model.repositories.ProductInCartRepository;
import fr.fournil.bakery.model.repositories.ProductRepository;


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
		Optional<Product> productFromStock= this.productRepository.findById(idProduct);
		
		//ProductInCart productInCart= productInCartRepository.findByProductId(productForm.getProductId());
		//productInCart.setProduct(productggg);
		// il ya une erreur à gere entre l'id du produit et le formatType dans le productForm faut ajouter une contrainte
	
		Format oneFormat=  this.formatRepository.findByFormatType(productForm.getFormatChoosen());
		FrequencyDeliveryType frenquencyType=frequenceDeliveryTypeRepository.findByFrequencyCommandeProduct(productForm.getFrequencyCommandeProduct());
		Product oneProduct=productFromStock.get();
		oneProduct.setId(idProduct);
		oneProduct.setProductName(oneProduct.getProductName());
		ProductInCart productToAdd=new ProductInCart();
		//ProductInCart productToAdd=productInCartRepository.findByProductId(idProduct);
		productToAdd.setId(oneProduct.getId());
		 System.out.println("productToAdd.getId()" + oneProduct.getId());
		productToAdd.setProduct(oneProduct);
		productToAdd.setFrequencyDeliveryType( frenquencyType);
		productToAdd.setQuantity(productForm.getQuantity());
		productToAdd.setFormat(oneFormat);
		productToAdd.setShoppingCart( productToAdd.getShoppingCart());
		productToAdd.setTotalPricePerProduct(productToAdd.getTotalPricePerProduct());//calculé directement enforçant le constructeur
		productInCartRepository.save(productToAdd);
		 System.out.println("productTotalPrice=" + productToAdd.getTotalPricePerProduct());
		 //System.out.println("productToAdd.getId()" + productToAdd.getId());
		return Optional.of(productToAdd);
	}
	
	
//////////////////////////////////////////////////////////	
}
