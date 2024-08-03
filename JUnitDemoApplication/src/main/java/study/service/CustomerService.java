package study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import study.model.Customers;
import study.repository.CustomerRepository;
import study.specification.CustomerSpecification;


@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	//To select all customers from a particular country
	public List<Customers> getCustomersByCountry (String country){
		
		Specification<Customers> byCountry =
				Specification.where(CustomerSpecification.getCustomersByCountry(country));
		return customerRepository.findAll(byCountry);
	}
	
	public List<Customers> selectByCountries (String ... countries){
		Specification<Customers> manyCountries =
				Specification.where(CustomerSpecification.selectByCountries(countries));
		return customerRepository.findAll(manyCountries);
		
	}
	public List<Customers> orderedByCountry(){
		Specification<Customers> spec = 
			Specification.where(CustomerSpecification.orderedByCountry());
		return customerRepository.findAll(spec);
	}
	
	public List<Customers> orderedByCountryAndCity(){
		Specification<Customers> spec = 
				Specification.where(CustomerSpecification.orderedByCountryAndCity());
			return customerRepository.findAll(spec);
	}

}
