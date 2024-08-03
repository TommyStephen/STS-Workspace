package study.specification;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import study.model.Customers;

public class CustomerSpecification {

	//To select all customers from a particular country	
	public static Specification<Customers> getCustomersByCountry(String country){
		return (root, criteria, criteriaBuilder)->
		criteriaBuilder.equal(root.get("country"), country);	
	}
	//To select all customers from more than one country
	public static Specification<Customers> selectByCountries(String... countries) {
	    return (root, query, criteriaBuilder) -> {
	        CriteriaBuilder.In<String> inClause = criteriaBuilder.in(root.get("country"));
	        for (String country : countries) {
	            inClause.value(country);
	        }
	        return inClause;
	    };
	}
	//To select all from customers table ordered by country
	public static Specification<Customers> orderedByCountry(){
		return(a, b, c)->{
			//Add ordering to the query by country
			b.orderBy(c.asc(a.get("customerName")));
			//return null because no filtering is done (no where clause)
			return null;
		};
	}
	
	//First ordered by country and then by city
		public static Specification<Customers> orderedByCountryAndCity(){
			return(a, b, c)->{
				//Add ordering to the query by country
				b.orderBy(
						c.asc(a.get("country")),
						c.asc(a.get("city")));
				//return null because no filtering is done (no where clause)
				return null;
			};
		}
	
	
	
	
	
}
