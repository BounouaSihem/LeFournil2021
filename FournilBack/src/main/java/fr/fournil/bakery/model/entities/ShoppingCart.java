package fr.fournil.bakery.model.entities;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="shoppingCart")
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToMany(mappedBy = "shoppingCart",cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
	//@JsonManagedReference
	private Set<ProductInCart> productInCartSet = new HashSet<ProductInCart>();
	
	@OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@JoinColumn( name="commande_id" )
	private Commande commande;
	
	private double totalPriceInCart;

	public ShoppingCart() {
		super();
	}

	
	
	public ShoppingCart(Long id, Set<ProductInCart> productInCartSet, Commande commande, double totalPriceInCart) {
		super();
		this.id = id;
		this.productInCartSet = productInCartSet;
		this.commande = commande;
		this.totalPriceInCart = totalPriceInCart;
	}



	public ShoppingCart(Set<ProductInCart> productInCartSet, Commande commande, double totalPriceInCart) {
		super();
		this.productInCartSet = productInCartSet;
		this.commande = commande;
		this.totalPriceInCart = totalPriceInCart;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Set<ProductInCart> getProductInCartSet() {
		return productInCartSet;
	}



	public void setProductInCartSet(Set<ProductInCart> productInCartSet) {
		this.productInCartSet = productInCartSet;
	}



	public Commande getCommande() {
		return commande;
	}



	public void setCommande(Commande commande) {
		this.commande = commande;
	}



	public double getTotalPriceInCart() {
		return totalPriceInCart;
	}



	public void setTotalPriceInCart(double totalPriceInCart) {
		this.totalPriceInCart = totalPriceInCart;
	}



	@Override
    public int hashCode() {
        return Objects.hash(id, totalPriceInCart);
    }

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id +  ", totalPriceInCart=" + totalPriceInCart + "]";
	}

	
	
	
	
}
