package humanity;

public abstract class Human {
	
	private String firstName;
	private String lastName;
	
	public Human() {
		// TODO Auto-generated constructor stub
	}
	
	public Human(String firstName, String lastName ) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String toString() {
		return "firstName" + firstName + "lastName" + lastName;
	}


}
