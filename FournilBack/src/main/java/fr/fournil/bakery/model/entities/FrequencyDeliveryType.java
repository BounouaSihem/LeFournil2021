package fr.fournil.bakery.model.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="frequencyDeliveryType")
public class FrequencyDeliveryType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Enumerated(EnumType.STRING)
	//@NaturalId
   // @Column(length = 100)
	private String frequencyCommandeProduct;
	//private FrequencyCommandeProductEnum  frequencyCommandeProductEnum;
	
	
	   
	   @OneToMany(mappedBy = "frequencyDeliveryType", cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
	   @JsonIgnore
	   private Set<ProductInCart> productInCartSet = new HashSet<ProductInCart>();
	
	public FrequencyDeliveryType() {
		super();
	}

	public FrequencyDeliveryType(Long id, String frequencyCommandeProduct, Set<ProductInCart> productInCartSet) {
		super();
		this.id = id;
		this.frequencyCommandeProduct = frequencyCommandeProduct;
		this.productInCartSet = productInCartSet;
	}

	public FrequencyDeliveryType(String frequencyCommandeProduct, Set<ProductInCart> productInCartSet) {
		super();
		this.frequencyCommandeProduct = frequencyCommandeProduct;
		this.productInCartSet = productInCartSet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrequencyCommandeProduct() {
		return frequencyCommandeProduct;
	}

	public void setFrequencyCommandeProduct(String frequencyCommandeProduct) {
		this.frequencyCommandeProduct = frequencyCommandeProduct;
	}

	public Set<ProductInCart> getProductInCartSet() {
		return productInCartSet;
	}

	public void setProductInCartSet(Set<ProductInCart> productInCartSet) {
		this.productInCartSet = productInCartSet;
	}


	@Override
    public int hashCode() {
        return Objects.hash(id, frequencyCommandeProduct);
    }

	@Override
	public String toString() {
		return "FrequencyDeliveryType [id=" + id + ", frequencyCommandeProduct=" + frequencyCommandeProduct
				+ "]";
	}
	
	

	

	
	
	
	

}
