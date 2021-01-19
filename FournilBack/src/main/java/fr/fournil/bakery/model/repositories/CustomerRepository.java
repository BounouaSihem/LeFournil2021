package fr.fournil.bakery.model.repositories;

import java.util.List;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fournil.bakery.model.entities.Customer;



@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long>{
	List<Customer> findAll();	
	Optional<Customer> findById(Long id);

	

}
