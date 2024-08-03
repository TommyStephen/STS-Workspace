package study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import study.model.Customers;
import study.service.CustomerService;


@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("customers/get_customers_by_country/{country}")
	public List<Customers> getxxxx(@PathVariable String country){
		return customerService.getCustomersByCountry(country);
	}
	
	@GetMapping("customers/by-countries")
    public List<Customers> findCustomers(@RequestBody List<String> countries) {
        return customerService.selectByCountries(countries.toArray(new String[0]));
    }
	
	@GetMapping("customers/findCustomersOrderedByCountry")
    public List<Customers> findCustomersOrderedByCountry() {
        return customerService.orderedByCountry();
    }
	@GetMapping("customers/orderedByCountryAndCity")
	public List<Customers> orderedByCountryAndCity() {
        return customerService.orderedByCountryAndCity();
    }
}
