package fr.fournil.bakery.model.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "photoProductList")
public class PhotoProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private String photoUrlName;
 

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST})
    @NotFound(action=NotFoundAction.IGNORE)
    @JsonIgnore

    private Product productIdName;

	public PhotoProduct() {
		super();
	}
	public PhotoProduct(Long id, String photoUrlName, Product productIdName) {
		super();
		this.id = id;
		this.photoUrlName = photoUrlName;
		this.productIdName = productIdName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getPhotoUrlName() {
		return photoUrlName;
	}


	public void setPhotoUrlName(String photoUrlName) {
		this.photoUrlName = photoUrlName;
	}


	public Product getProductIdName() {
		return productIdName;
	}
	public void setProductIdName(Product productIdName) {
		this.productIdName = productIdName;
	}
	@Override
    public int hashCode() {
        return Objects.hash(id, photoUrlName);
    }
	@Override
	public String toString() {
		return "PhotoProduct [id=" + id + ", photoUrlName=" + photoUrlName + ", productIdName=" + productIdName + "]";
	}
 

}
