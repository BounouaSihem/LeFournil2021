package fr.fournil.bakery.model.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ProductInCart")
public class ProductInCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// @JsonIgnoreProperties(value={"commande", "photoProductSet",
	// "productComposition",
	// "productPerKgPrice","productSpecification","productSummary","limitStockProduct"
	// })

	@OneToOne(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
	// @JoinColumn(name = "product_id")
	private Product product;

	@Min(1)
	private Integer quantity;

	@ManyToOne(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
	private FrequencyDeliveryType frequencyDeliveryType;

	private double totalPricePerProduct;

	@ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
	// @JoinTable(name = " productInCartListInShoppinCard", joinColumns =
	// @JoinColumn(name = "productInCart_id"), inverseJoinColumns = @JoinColumn(name
	// = "shoppingCart_id"))
	// @JoinColumn(name = "shoppingCart_id")
	
	private Set<ShoppingCart> shoppingCart = new HashSet<>();

	public ProductInCart() {
		super();
	}


	
	
	public ProductInCart(Long id, Product product, @Min(1) Integer quantity,
			FrequencyDeliveryType frequencyDeliveryType, double totalPricePerProduct, Set<ShoppingCart> shoppingCart) {
		super();
		this.id = product.getId();
		this.product = product;
		this.quantity = quantity;
		this.frequencyDeliveryType = frequencyDeliveryType;
		this.totalPricePerProduct = totalPricePerProduct;
		this.shoppingCart = shoppingCart;
	}



	public ProductInCart(Product product, @Min(1) Integer quantity, FrequencyDeliveryType frequencyDeliveryType,
			double totalPricePerProduct, Set<ShoppingCart> shoppingCart) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.frequencyDeliveryType = frequencyDeliveryType;
		this.totalPricePerProduct = totalPricePerProduct;
		this.shoppingCart = shoppingCart;
	}


	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Product getProduct() {
		return product;
	}




	public void setProduct(Product product) {
		this.product = product;
	}




	public Integer getQuantity() {
		return quantity;
	}




	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}




	public FrequencyDeliveryType getFrequencyDeliveryType() {
		return frequencyDeliveryType;
	}




	public void setFrequencyDeliveryType(FrequencyDeliveryType frequencyDeliveryType) {
		this.frequencyDeliveryType = frequencyDeliveryType;
	}




	public double getTotalPricePerProduct() {
		return totalPricePerProduct;
	}




	public void setTotalPricePerProduct(double totalPricePerProduct) {
		this.totalPricePerProduct = totalPricePerProduct;
	}




	public Set<ShoppingCart> getShoppingCart() {
		return shoppingCart;
	}




	public void setShoppingCart(Set<ShoppingCart> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}




	@Override
	public int hashCode() {
		return Objects.hash(id, product);
	}




	@Override
	public String toString() {
		return "ProductInCart [id=" + id + ", product=" + product + ", quantity=" + quantity
				+ ", frequencyDeliveryType=" + frequencyDeliveryType + ", totalPricePerProduct=" + totalPricePerProduct
				+ ", shoppingCart=" + shoppingCart + "]";
	}

	
}
