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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "formatList")
public class Format {
	 private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String formatType;
	
	private double formatWeight;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JsonIgnore
	private Set<Product> productList = new HashSet<>();

	public Format() {
		super();
	}

	
	
	public Format(Long id, String formatType, double formatWeight, Set<Product> productList) {
		super();
		this.id = id;
		this.formatType = formatType;
		this.formatWeight = formatWeight;
		this.productList = productList;
	}



	public Format(String formatType, double formatWeight, Set<Product> productList) {
		super();
		this.formatType = formatType;
		this.formatWeight = formatWeight;
		this.productList = productList;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFormatType() {
		return formatType;
	}



	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}



	public double getFormatWeight() {
		return formatWeight;
	}



	public void setFormatWeight(double formatWeight) {
		this.formatWeight = formatWeight;
	}



	public Set<Product> getProductList() {
		return productList;
	}



	public void setProductList(Set<Product> productList) {
		this.productList = productList;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
    public int hashCode() {
        return Objects.hash(id, formatType);
    }


	@Override
	public String toString() {
		return "Format [id=" + id + ", formatType=" + formatType + ", formatWeight=" + formatWeight + "]";
	}
	
	
	
}
