package study.model;

public class School {
	private String name;
	private Principal principal;
	public School() {
		super();
	}
	
	public School(String name, Principal principal) {
		super();
		this.name = name;
		this.principal = principal;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Principal getprincipal() {
		return principal;
	}
	public void setprincipal(Principal principal) {
		this.principal = principal;
	}

	@Override
	public String toString() {
		return "School [name=" + name + ", principal=" + principal + "]";
	}
	
	
}
