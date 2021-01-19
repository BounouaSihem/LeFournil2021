package fr.fournil.bakery.model.entities;


import java.util.Date;
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

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;





@Entity
@Table(name = "commande")
public class Commande {
	
	private static final Long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	
	@ManyToOne(cascade = { CascadeType.PERSIST}, fetch = FetchType.EAGER)
	//@JsonIgnoreProperties(value={"email", "mobileNumber","isPresentInDB"})
	//@JsonManagedReference
	//@JoinColumn(name = "customer_id")
	private Customer customer;
	
	private Date dateCommande;
	

	@ManyToOne(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
	@JsonIgnoreProperties("commandeSet")
	private DeliveryPointAdressAndDates deliveryPointAdressAndDates ;
	
	@OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@JoinColumn( name="statutCommande_id" )
	private StatutCommande statutCommande;
	
	private double totalPriceByCommande ;
	public Commande() {
		super();
	}

	public Commande(Long id, Customer customer, Date dateCommande,
			DeliveryPointAdressAndDates deliveryPointAdressAndDates, StatutCommande statutCommande,
			double totalPriceByCommande) {
		super();
		this.id = id;
		this.customer = customer;
		this.dateCommande = dateCommande;
		this.deliveryPointAdressAndDates = deliveryPointAdressAndDates;
		this.statutCommande = statutCommande;
		this.totalPriceByCommande = totalPriceByCommande;
	}



	public Commande(Customer customer, Date dateCommande, DeliveryPointAdressAndDates deliveryPointAdressAndDates,
			StatutCommande statutCommande, double totalPriceByCommande) {
		super();
		this.customer = customer;
		this.dateCommande = dateCommande;
		this.deliveryPointAdressAndDates = deliveryPointAdressAndDates;
		this.statutCommande = statutCommande;
		this.totalPriceByCommande = totalPriceByCommande;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public DeliveryPointAdressAndDates getDeliveryPointAdressAndDates() {
		return deliveryPointAdressAndDates;
	}

	public void setDeliveryPointAdressAndDates(DeliveryPointAdressAndDates deliveryPointAdressAndDates) {
		this.deliveryPointAdressAndDates = deliveryPointAdressAndDates;
	}

	public StatutCommande getStatutCommande() {
		return statutCommande;
	}

	public void setStatutCommande(StatutCommande statutCommande) {
		this.statutCommande = statutCommande;
	}

	public double getTotalPriceByCommande() {
		return totalPriceByCommande;
	}

	public void setTotalPriceByCommande(double totalPriceByCommande) {
		this.totalPriceByCommande = totalPriceByCommande;
	}

	public static Long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", customer=" + customer + ", dateCommande=" + dateCommande + ", deliveryPointAdressAndDates=" + deliveryPointAdressAndDates
				+ ", statutCommande=" + statutCommande + "]";
	}


	





	
	
	
	


	

	

	
}
