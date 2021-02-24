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
	
	private Integer factorFrequency;
	   
	   @OneToMany(mappedBy = "frequencyDeliveryType", cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
	   @JsonIgnore
	   private Set<ProductInCart> productInCartSet = new HashSet<ProductInCart>();
	
	public FrequencyDeliveryType() {
		super();
	}

	
	public FrequencyDeliveryType(Long id, String frequencyCommandeProduct, Integer factorFrequency,
			Set<ProductInCart> productInCartSet) {
		super();
		this.id = id;
		this.frequencyCommandeProduct = frequencyCommandeProduct;
		this.factorFrequency = factorFrequency;
		this.productInCartSet = productInCartSet;
	}


	public FrequencyDeliveryType(String frequencyCommandeProduct, Integer factorFrequency,
			Set<ProductInCart> productInCartSet) {
		super();
		this.frequencyCommandeProduct = frequencyCommandeProduct;
		this.factorFrequency = factorFrequency;
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


	public Integer getFactorFrequency() {
		return factorFrequency;
	}


	public void setFactorFrequency(Integer factorFrequency) {
		this.factorFrequency = factorFrequency;
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
