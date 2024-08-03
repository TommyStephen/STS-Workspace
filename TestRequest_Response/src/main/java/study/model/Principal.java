package study.model;

public class Principal {

	private String name;
	private String city;
	public Principal(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	public Principal() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Principal [name=" + name + ", city=" + city + "]";
	}
		
	
}
