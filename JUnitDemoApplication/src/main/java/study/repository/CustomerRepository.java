package study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import study.model.Customers;

public interface CustomerRepository extends 
JpaRepository<Customers, Integer>, JpaSpecificationExecutor<Customers> {

	
}
