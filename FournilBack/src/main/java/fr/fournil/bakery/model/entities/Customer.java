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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customerList")
public class Customer {
	private static final Long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 2, max = 20, message = "firstName must be between 2 and 20 characters")
	private String firstName;

	@Size(min = 2, max = 20, message = "lastName must be between 2 and 20 characters")
	private String lastName;

	@NotNull(message = "Email cannot be null")
	@Email(message = "Email should be valid")
	private String email;     

	private String mobileNumber;
	
	

	//@NaturalId
    //@Column
	//private DeliveryPointAdressAndDates deliveryPointAdressAndDates;
	
	//@JoinColumn(name = "commande_id")
	//@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
	//@JsonBackReference
	private Set<Commande> commandeSet= new HashSet<Commande>();

    private boolean isPresentInDB;
  
  
	public Customer() {
		super();
	}

	public Customer(Long id,
			@Size(min = 2, max = 20, message = "firstName must be between 2 and 20 characters") String firstName,
			@Size(min = 2, max = 20, message = "lastName must be between 2 and 20 characters") String lastName,
			@NotNull(message = "Email cannot be null") @Email(message = "Email should be valid") String email,
			String mobileNumber, Set<Commande> commandeSet, boolean isPresentInDB) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.commandeSet = commandeSet;
		this.isPresentInDB = isPresentInDB;
	}


	public Customer(
			@Size(min = 2, max = 20, message = "firstName must be between 2 and 20 characters") String firstName,
			@Size(min = 2, max = 20, message = "lastName must be between 2 and 20 characters") String lastName,
			@NotNull(message = "Email cannot be null") @Email(message = "Email should be valid") String email,
			String mobileNumber, Set<Commande> commandeSet, boolean isPresentInDB) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.commandeSet = commandeSet;
		this.isPresentInDB = isPresentInDB;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Set<Commande> getCommandeSet() {
		return commandeSet;
	}

	public void setCommandeSet(Set<Commande> commandeSet) {
		this.commandeSet = commandeSet;
	}

	public boolean isPresentInDB() {
		return isPresentInDB;
	}

	public void setPresentInDB(boolean isPresentInDB) {
		this.isPresentInDB = isPresentInDB;
	}

	public static Long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public int hashCode() {
        return Objects.hash(id, lastName);
    }

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", isPresentInDB=" + isPresentInDB + "]";
	}



	
	


	
	

	

	
	

}
