package humanity;

public class Student extends Human{

	private String faculty;
	
	public Student(String firstName, String lastName , String faculty) {
		super(firstName, lastName);
		this.faculty = faculty;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String faculty) {
		this.faculty = faculty;
	}
	
	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	
	public String toString() {
		return  super.toString() + "faculty" + faculty;
	}


	
}
