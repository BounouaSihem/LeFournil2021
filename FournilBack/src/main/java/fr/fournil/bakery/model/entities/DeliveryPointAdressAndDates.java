package fr.fournil.bakery.model.entities;




import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="deliveryPointAdressAndDates")
public class DeliveryPointAdressAndDates {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@NaturalId
   // @Column(columnDefinition = "TEXT")
	private String deliveryPointAdress;
	
	//@NaturalId
	//@Column(name = "deliveryDate",columnDefinition="int", insertable=false)
	//@Temporal(TemporalType.TIMESTAMP) //(columnDefinition = "TEXT")
    private  DayOfWeek deliveryDate;
	
	//@NaturalId
	//@Column(name = "orderDeadline",columnDefinition="int", insertable=false)
	//@Temporal(TemporalType.TIMESTAMP) //(columnDefinition = "TEXT") //(columnDefinition = "TEXT")
	
	private DayOfWeek orderDeadline;
    
	
	
	@OneToMany(mappedBy = "deliveryPointAdressAndDates", cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
	private Set<Commande> commandeSet = new HashSet<Commande>();

	public DeliveryPointAdressAndDates() {
		super();
	}

	
	public DeliveryPointAdressAndDates(Long id, String deliveryPointAdress, DayOfWeek deliveryDate,
			DayOfWeek orderDeadline, Set<Commande> commandeSet) {
		super();
		this.id = id;
		this.deliveryPointAdress = deliveryPointAdress;
		this.deliveryDate = deliveryDate;
		this.orderDeadline = orderDeadline;
		this.commandeSet = commandeSet;
	}


	public DeliveryPointAdressAndDates(String deliveryPointAdress, DayOfWeek deliveryDate, DayOfWeek orderDeadline,
			Set<Commande> commandeSet) {
		super();
		this.deliveryPointAdress = deliveryPointAdress;
		this.deliveryDate = deliveryDate;
		this.orderDeadline = orderDeadline;
		this.commandeSet = commandeSet;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDeliveryPointAdress() {
		return deliveryPointAdress;
	}


	public void setDeliveryPointAdress(String deliveryPointAdress) {
		this.deliveryPointAdress = deliveryPointAdress;
	}


	public DayOfWeek getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(DayOfWeek deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public DayOfWeek getOrderDeadline() {
		return orderDeadline;
	}


	public void setOrderDeadline(DayOfWeek orderDeadline) {
		this.orderDeadline = orderDeadline;
	}


	public Set<Commande> getCommandeSet() {
		return commandeSet;
	}


	public void setCommandeSet(Set<Commande> commandeSet) {
		this.commandeSet = commandeSet;
	}


	@Override
	public String toString() {
		return "DeliveryPointAdressAndDates [id=" + id + ", deliveryPointAdress=" + deliveryPointAdress
				+ ", deliveryDate=" + deliveryDate + ", orderDeadline=" + orderDeadline
				+ "]";
	}


	

	

	

	
	

	
	
}
