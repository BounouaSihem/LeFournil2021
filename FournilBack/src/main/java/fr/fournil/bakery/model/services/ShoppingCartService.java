package fr.fournil.bakery.model.services;

import java.util.List;
import java.util.Optional;
import fr.fournil.bakery.model.entities.ShoppingCart;

public interface ShoppingCartService {
	List <ShoppingCart> getShoppingCartList();
	Optional<ShoppingCart> getShoppingCartById(Long id);
}
