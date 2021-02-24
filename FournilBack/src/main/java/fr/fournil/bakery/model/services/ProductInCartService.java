package fr.fournil.bakery.model.services;

import java.util.List;
import java.util.Optional;

import fr.fournil.bakery.model.entities.Format;
import fr.fournil.bakery.model.entities.FrequencyDeliveryType;
import fr.fournil.bakery.model.entities.ProductForm;
import fr.fournil.bakery.model.entities.ProductInCart;



public interface ProductInCartService {
	List <ProductInCart> getProductInCartList();
	Optional<ProductInCart> getProductInCartById(Long id);
	//Optional<ProductInCart> addAndSaveProductInCart(ProductForm productForm);
	//Optional<ProductInCart> addAndSaveProductInCart( Long productId,Integer quantity, String formatChoosen,String frequencyCommandeProduct);
	//Optional<ProductInCart> addAndSaveProductInCart(Long id, ProductForm productForm);
	
	Optional<ProductInCart> addAndSaveProductInCart(Long idProduct, ProductForm productForm);
}
