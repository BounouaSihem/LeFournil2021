package fr.fournil.bakery.model.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.*;


@Entity
@Table(name = "productSet")
//@Inheritance(strategy=InheritanceType.JOINED)
//@MappedSuperclass
public class Product {
	 private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 protected Long id;
	
	private String productName;
	@Column(columnDefinition = "TEXT")
	private String productSummary;
	
	@Column(columnDefinition = "TEXT")
	private String productComposition;
	
	@Column(columnDefinition = "TEXT")
	private String productSpecification;

	
   @OneToMany(mappedBy = "productIdName", cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
   //@JsonManagedReference
   //@JsonIgnore
	private Set<PhotoProduct> photoProductSet = new HashSet<PhotoProduct>();
	
   @ManyToMany(mappedBy = "productList", cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
  // @JsonManagedReference
   private Set<Format> formatSet = new HashSet<Format>();
	
 
   @OneToOne(mappedBy = "product", cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
   @JsonIgnore
   private ProductInCart productInCart;
   
    private double productPerKgPrice;
	
    @Min(0)
	private Integer limitStockProduct;
	
	

	public Product() {
		super();
	}

	

	public Product(Long id, String productName, String productSummary, String productComposition,
			String productSpecification, Set<PhotoProduct> photoProductSet, Set<Format> formatSet,
			ProductInCart productInCart, double productPerKgPrice, @Min(0) Integer limitStockProduct) {
		super();
		this.id = id;
		this.productName = productName;
		this.productSummary = productSummary;
		this.productComposition = productComposition;
		this.productSpecification = productSpecification;
		this.photoProductSet = photoProductSet;
		this.formatSet = formatSet;
		this.productInCart = productInCart;
		this.productPerKgPrice = productPerKgPrice;
		this.limitStockProduct = limitStockProduct;
	}


	public Product(String productName, String productSummary, String productComposition, String productSpecification,
			Set<PhotoProduct> photoProductSet, Set<Format> formatSet, ProductInCart productInCart,
			double productPerKgPrice, @Min(0) Integer limitStockProduct) {
		super();
		this.productName = productName;
		this.productSummary = productSummary;
		this.productComposition = productComposition;
		this.productSpecification = productSpecification;
		this.photoProductSet = photoProductSet;
		this.formatSet = formatSet;
		this.productInCart = productInCart;
		this.productPerKgPrice = productPerKgPrice;
		this.limitStockProduct = limitStockProduct;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getProductSummary() {
		return productSummary;
	}



	public void setProductSummary(String productSummary) {
		this.productSummary = productSummary;
	}



	public String getProductComposition() {
		return productComposition;
	}



	public void setProductComposition(String productComposition) {
		this.productComposition = productComposition;
	}



	public String getProductSpecification() {
		return productSpecification;
	}



	public void setProductSpecification(String productSpecification) {
		this.productSpecification = productSpecification;
	}



	public Set<PhotoProduct> getPhotoProductSet() {
		return photoProductSet;
	}



	public void setPhotoProductSet(Set<PhotoProduct> photoProductSet) {
		this.photoProductSet = photoProductSet;
	}



	public Set<Format> getFormatSet() {
		return formatSet;
	}



	public void setFormatSet(Set<Format> formatSet) {
		this.formatSet = formatSet;
	}



	public ProductInCart getProductInCart() {
		return productInCart;
	}



	public void setProductInCart(ProductInCart productInCart) {
		this.productInCart = productInCart;
	}



	public double getProductPerKgPrice() {
		return productPerKgPrice;
	}



	public void setProductPerKgPrice(double productPerKgPrice) {
		this.productPerKgPrice = productPerKgPrice;
	}



	public Integer getLimitStockProduct() {
		return limitStockProduct;
	}



	public void setLimitStockProduct(Integer limitStockProduct) {
		this.limitStockProduct = limitStockProduct;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
    public int hashCode() {
        return Objects.hash(id, productName);
    }



	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productSummary=" + productSummary
				+ ", productComposition=" + productComposition + ", productSpecification=" + productSpecification
				 + ", productPerKgPrice=" + productPerKgPrice + ", limitStockProduct="
				+ limitStockProduct + "]";
	}

	


	
	



	

	
}
