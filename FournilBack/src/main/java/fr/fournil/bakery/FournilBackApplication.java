package fr.fournil.bakery;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;

import fr.fournil.bakery.model.entities.Commande;
import fr.fournil.bakery.model.entities.Customer;
import fr.fournil.bakery.model.entities.DeliveryPointAdressAndDates;
import fr.fournil.bakery.model.entities.Format;
import fr.fournil.bakery.model.entities.FrequencyDeliveryType;
import fr.fournil.bakery.model.entities.PhotoProduct;
import fr.fournil.bakery.model.entities.Product;
import fr.fournil.bakery.model.entities.ProductInCart;
import fr.fournil.bakery.model.entities.ShoppingCart;
import fr.fournil.bakery.model.entities.StatutCommande;
import fr.fournil.bakery.model.repositories.CommandeRepository;
import fr.fournil.bakery.model.repositories.CustomerRepository;
import fr.fournil.bakery.model.repositories.DeliveryPointAdressAndDatesRepository;
import fr.fournil.bakery.model.repositories.FormatRepository;
import fr.fournil.bakery.model.repositories.FrequenceDeliveryTypeRepository;
import fr.fournil.bakery.model.repositories.PhotoProductRepository;
import fr.fournil.bakery.model.repositories.ProductInCartRepository;
import fr.fournil.bakery.model.repositories.ProductRepository;
import fr.fournil.bakery.model.repositories.ShoppingCartRepository;
import fr.fournil.bakery.model.repositories.StatutCommandeRepository;
import fr.fournil.bakery.tools.json.JSONLoader;


@SpringBootApplication
@EnableAsync
public class FournilBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FournilBackApplication.class, args);
	}
	

	
	
	@Bean
	@Profile({ "dev", "test" })
	ApplicationRunner initProductRepository( ProductRepository  productRepository) {
		return args -> {
			if (  productRepository.findAll().isEmpty()) {
				new JSONLoader<>("src/main/resources/data/product.json",  Product[].class, productRepository).load();
			}
		};
	}
		
	@Bean
	@Profile({ "dev", "test" })
	ApplicationRunner initFormatRepository(FormatRepository formatRepository) {
		return args -> {
			if ( formatRepository.findAll().isEmpty()) {
				new JSONLoader<>("src/main/resources/data/format.json", Format[].class, formatRepository).load();
			}
		};
	}
	
	@Bean
	@Profile({ "dev", "test" })
	ApplicationRunner initPhotoRepository(PhotoProductRepository photoProductRepository) {
		return args -> {
			if ( photoProductRepository.findAll().isEmpty()) {
				new JSONLoader<>("src/main/resources/data/photoProduct.json", PhotoProduct[].class, photoProductRepository).load();
			}
		};
	}
	
	
	@Bean
	@Profile({ "dev", "test" })
	ApplicationRunner initDeliveryPointAdressAndDatesRepository(DeliveryPointAdressAndDatesRepository deliveryPointAdressAndDatesRepository) {
		return args -> {
			if ( deliveryPointAdressAndDatesRepository.findAll().isEmpty()) {
				new JSONLoader<>("src/main/resources/data/deliveryPointAdressAndDates.json", DeliveryPointAdressAndDates[].class, deliveryPointAdressAndDatesRepository).load();
			}
		};
	}
	
	@Bean
	@Profile({ "dev", "test" })
	ApplicationRunner initFrequenceDeliveryTypeRepository(FrequenceDeliveryTypeRepository frequenceDeliveryTypeRepository) {
		return args -> {
			if ( frequenceDeliveryTypeRepository.findAll().isEmpty()) {
				new JSONLoader<>("src/main/resources/data/frequenceDeliveryType.json", FrequencyDeliveryType[].class, frequenceDeliveryTypeRepository).load();
			}
		};
	}
	
	@Bean
	@Profile({ "dev", "test" })
	ApplicationRunner initStatutCommandeRepository(StatutCommandeRepository statutCommandeRepository) {
		return args -> {
			if ( statutCommandeRepository.findAll().isEmpty()) {
				new JSONLoader<>("src/main/resources/data/statutCommande.json",StatutCommande[].class, statutCommandeRepository).load();
			}
		};
	}
	
	@Bean
	@Profile({ "dev", "test" })
	ApplicationRunner initCustomerRepository(CustomerRepository customerRepository) {
		return args -> {
			if ( customerRepository.findAll().isEmpty()) {
				new JSONLoader<>("src/main/resources/data/customer.json", Customer[].class, customerRepository).load();
			}
		};
	}
	@Bean
	@Profile({ "dev", "test" })
	ApplicationRunner initCommandeRepository(CommandeRepository commandeRepository) {
		return args -> {
			if ( commandeRepository.findAll().isEmpty()) {
				new JSONLoader<>("src/main/resources/data/commande.json", Commande[].class, commandeRepository).load();
			}
		};
	}
	
	
	
	
	@Bean
	@Profile({ "dev", "test" })
	ApplicationRunner initShoppingCartRepository(ShoppingCartRepository  shoppingCartRepository) {
		return args -> {
			if (  shoppingCartRepository.findAll().isEmpty()) {
				new JSONLoader<>("src/main/resources/data/shoppingCart.json",  ShoppingCart[].class, shoppingCartRepository).load();
			}
		};
	}
	
	@Bean
	@Profile({ "dev", "test" })
	ApplicationRunner initProductInCartRepository(ProductInCartRepository  productInCartRepository) {
		return args -> {
			if (  productInCartRepository.findAll().isEmpty()) {
				new JSONLoader<>("src/main/resources/data/productInCart.json",  ProductInCart[].class, productInCartRepository).load();
			}
		};
	}
	
	
	
	
	
	
	
	
	
	
	
}
