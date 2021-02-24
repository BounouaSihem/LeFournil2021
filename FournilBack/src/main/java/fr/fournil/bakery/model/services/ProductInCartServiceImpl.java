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
	
	/*@Override
	public Optional<ProductInCart> addAndSaveProductInCart(ProductInCart productToAdd,Long productId) {
		Product product=productInCartRepository.findByProductId(productId);
		productToAdd.setProduct(product);
		productToAdd.setQuantity(productToAdd.getQuantity());
		productToAdd.setFrequencyDeliveryType(productToAdd.getFrequencyDeliveryType());
		productToAdd.setTotalPricePerProduct(productToAdd.getTotalPricePerProduct());
		productInCartRepository.save(productToAdd);
		return Optional.of(productToAdd);
	}*/

	/*@Override
	public Optional<ProductInCart> addAndSaveProductInCart(Long productId, Integer quantity, String formatChoosen,
			String frequencyCommandeProduct) {
		Format oneFormat=  formatRepository.findByProductListId(productId);
		oneFormat.setFormatType(formatChoosen);
		Product product=productInCartRepository.findByProductId(productId);
		//product.setFormatSet(oneFormat);
		ProductInCart productToAdd=new ProductInCart();
		FrequencyDeliveryType frequencyType=productToAdd.getFrequencyDeliveryType();
		frequencyType.setFrequencyCommandeProduct(frequencyCommandeProduct);
		
		Set<Format> formatProduct=productToAdd.getProduct().getFormatSet();
		
		
		productToAdd.setProduct(product);
		productToAdd.setQuantity(quantity);
		productToAdd.setFrequencyDeliveryType(frequencyType);
		productToAdd.setTotalPricePerProduct(productToAdd.getTotalPricePerProduct());
		productInCartRepository.save(productToAdd);
		return Optional.of(productToAdd);
	}*/

	@Override
	public Optional<ProductInCart> addAndSaveProductInCart(Long idProduct ,ProductForm productForm) {
		idProduct=productForm.getProductId();
		Optional<Product> productFromStock= this.productRepository.findById(idProduct);
		
		//ProductInCart productInCart= productInCartRepository.findByProductId(productForm.getProductId());
		//productInCart.setProduct(productggg);
		Format oneFormat=  this.formatRepository.findByFormatType(productForm.getFormatChoosen());
		FrequencyDeliveryType frenquencyType=frequenceDeliveryTypeRepository.findByFrequencyCommandeProduct(productForm.getFrequencyCommandeProduct());
		Product oneProduct=productFromStock.get();
		oneProduct.setId(idProduct);
		oneProduct.setProductName(oneProduct.getProductName());
		ProductInCart productToAdd=new ProductInCart();
		productToAdd.setId(productForm.getProductId());
		productToAdd.setProduct(oneProduct);
		productToAdd.setFrequencyDeliveryType( frenquencyType);
		productToAdd.setQuantity(productForm.getQuantity());
		productToAdd.setFormat(oneFormat);
		productToAdd.setTotalPricePerProduct(productToAdd.getTotalPricePerProduct());//calculé directement enforçant le constructeur
		productToAdd=this.productInCartRepository.save(productToAdd);
		 System.out.println("productTotalPrice=" + productToAdd.getTotalPricePerProduct());
		return Optional.of(productToAdd);
	}
	/*public double calculatePriceOfProductIncart(Long idProduct, String formatType,String frequencyCommande,Integer quantity) {
		double totalPricePerProduct=0;
		Optional<Product> productFromStock= this.productRepository.findById(idProduct);
		Format oneFormat=  this.formatRepository.findByProductListId(productFromStock.get().getId());
		oneFormat.setFormatType(formatType);
		FrequencyDeliveryType frenquencyType=frequenceDeliveryTypeRepository.findByFrequencyCommandeProduct(frequencyCommande);
		
		double priceFormatWeight=(productFromStock.get().getProductPerKgPrice())*(oneFormat.getFormatWeight())*quantity;
		
		return totalPricePerProduct;
		}*/
	
//////////////////////////////////////////////////////////	
}
