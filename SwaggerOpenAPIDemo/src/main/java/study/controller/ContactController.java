package study.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import study.model.Contact;

@RestController
public class ContactController {

ConcurrentHashMap<String, Contact> contacts = new ConcurrentHashMap<>();
	
	@PostMapping("/")
	public ArrayList<Contact> populateMap() {
		contacts.put("1", new Contact("1", "Hari", "123-123-1234"));
		contacts.put("2", new Contact("2", "John", "123-123-2345"));
		contacts.put("3", new Contact("3", "Sonu", "123-123-3456"));
		contacts.put("4", new Contact("4", "Manu", "123-123-4567"));
		return new ArrayList<Contact> (contacts.values());
	}
	
	@GetMapping("/id")
	public Contact getContact(@PathVariable String id) {
		return contacts.get(id);
	}
	
	@GetMapping("/")
	public List<Contact> getAllContacts(){
		return new ArrayList<Contact> (contacts.values());
		
	}
	@PostMapping("/add")
	public Contact addContacts(@RequestBody Contact contact) {
		contacts.put(contact.getId(), contact);
		return contact;
	}
	
	
/*Now, the documentation will be available in JSON format at http://localhost:8080/v3/api-docs
The documentation will be available in YAML format at http://localhost:8080/v3/api-docs.yaml
The swagger UI will be available at http://localhost:8080/swagger-ui.html*/
}
