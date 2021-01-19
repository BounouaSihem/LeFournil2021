package fr.fournil.bakery.model.services;

import java.util.List;
import java.util.Optional;

import fr.fournil.bakery.model.entities.Product;




public interface ProductService {
	List <Product> getProductList();
	Optional<Product> getProductsById(Long id);
}
