package fr.fournil.bakery.model.entities;

import java.util.HashSet;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;


@Entity  
@Table(name="statutCommande")
public class StatutCommande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
	private StatutName statutName;
	
	public StatutCommande() {
		super();
	}

	public StatutCommande(Long id, StatutName statutName) {
		super();
		this.id = id;
		this.statutName = statutName;
	}


	public StatutCommande(StatutName statutName) {
		super();
		this.statutName = statutName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatutName getStatutName() {
		return statutName;
	}

	public void setStatutName(StatutName statutName) {
		this.statutName = statutName;
	}

	@Override
	public String toString() {
		return "StatutCommande [id=" + id + ", statutName=" + statutName + "]";
	}

	
	
	
	
}
