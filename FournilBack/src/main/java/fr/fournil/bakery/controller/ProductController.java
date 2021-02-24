package fr.fournil.bakery.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.google.common.net.HttpHeaders;

import fr.fournil.bakery.model.entities.Format;
import fr.fournil.bakery.model.entities.PhotoProduct;
import fr.fournil.bakery.model.entities.Product;
import fr.fournil.bakery.model.repositories.CommandeRepository;
import fr.fournil.bakery.model.repositories.CustomerRepository;
import fr.fournil.bakery.model.repositories.FormatRepository;
import fr.fournil.bakery.model.repositories.ProductRepository;
import fr.fournil.bakery.model.services.CommandeService;
import fr.fournil.bakery.model.services.CustomerService;
import fr.fournil.bakery.model.services.FormatService;
import fr.fournil.bakery.model.services.ProductService;

@CrossOrigin(origins = "*")
@RestController

@RequestMapping(value = "/products")
public class ProductController {

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
	private FormatService formatService;
	@Autowired
	private FormatRepository formatRepository;

	public ProductController(CustomerService customerService, CustomerRepository customerRepository,
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

	@GetMapping(value = "")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> listProducts = this.productService.getProductList();
		return new ResponseEntity<List<Product>>(listProducts, HttpStatus.OK);
	}

	@GetMapping(value = "format")
	public ResponseEntity<List<Format>> getAllFormatProduct() {
		List<Format> listformats = this.formatService.getFormatList();
		return new ResponseEntity<List<Format>>(listformats, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long id) {
		Product productById = this.productService.getProductsById(id).get();
				
				if (!this.productService.getProductsById(id).isPresent()) {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun produit trouvé avec l'id :" + id);
				} else

		return new ResponseEntity<Product>(productById, HttpStatus.OK);
	}
	

	/// Cas une seule photo:
	
	  @RequestMapping(value = "/{id}/photo/{idPhoto}", method = RequestMethod.GET, produces =MediaType.IMAGE_JPEG_VALUE) // @RequestParam("file")
	 
	  public ResponseEntity<byte[]> getphotoProduct(@PathVariable("id") Long id, @PathVariable("idPhoto") int idPhoto,
	  HttpServletResponse response) throws IOException {
	  
	  Optional<Product> currentProduct = this.productService.getProductsById(id);
	  
	  if (!currentProduct.isPresent()) { throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Aucun produit trouvé avec l'id :" + id); }
	 
	 Set<PhotoProduct> photoSetByProductId =currentProduct.get().getPhotoProductSet();
	    
	  System.out.println("photoSetByProductId=" + photoSetByProductId);
	  System.out.println("src/main/resources/" + "photoUrlName" + ".jpg");
	  
	  
	  ArrayList<PhotoProduct> listOfPhotoUrlByProductId1 = new ArrayList<PhotoProduct>(photoSetByProductId);
	  
	 //Set<String> photoUrlNameSetByProductId =new HashSet<String>();
	  
	  ArrayList<String> listOfPhotoUrlNameByProductId = new ArrayList<String>();
	  
	  for (int i = 0; i < listOfPhotoUrlByProductId1.size(); i++) {
	  
	  String photoSetByProductId2 =listOfPhotoUrlByProductId1.get(i).getPhotoUrlName();
	  
	  listOfPhotoUrlNameByProductId.add(photoSetByProductId2); }
	  
	  ///////////////////////////////////////////////////////////////////
	  System.out.println("listOfPhotoUrlNameByProductId======" +
	  listOfPhotoUrlNameByProductId); // File f = new
	 
	  File f = new File("src/main/resources/"+listOfPhotoUrlNameByProductId.get(idPhoto)+".png");
	  System.out.println("listOfPhotoUrlNameByProductId======" +listOfPhotoUrlNameByProductId.get(idPhoto));
	  BufferedImage o = ImageIO.read(f);
	  ByteArrayOutputStream b = new ByteArrayOutputStream();
	  ImageIO.write(o, "png", b);
	 
	  b.flush(); 
	  byte[] img = b.toByteArray();
	  b.close();
	  
	  return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img);
	  
	  }
	 
	  
	  
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}