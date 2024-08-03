package study.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OperatorDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	public OperatorDetails() {
		super();
	}

	public OperatorDetails(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
