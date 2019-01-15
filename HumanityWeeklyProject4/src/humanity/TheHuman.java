package humanity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class TheHuman {
	
	ArrayList<Student> students;
	ArrayList<Worker> workers;
	
	Database db = new Database();
	Connection conn = db.connect("jdbc:mysql://localhost:3306" ,"root", "root");
	
	public void deleteWorker(String firstName, String lastName) throws SQLException {
		
		String selectSQL = "SELECT id FROM humanity_weekly_project4.worker WHERE firstName = ? and lastName = ?";
		PreparedStatement preparedStatement1 = conn.prepareStatement(selectSQL);
		preparedStatement1.setString(1, firstName);
		preparedStatement1.setString(2, lastName);
		ResultSet rs = preparedStatement1.executeQuery();
		int id = -1;
		while (rs.next()) {
			id = rs.getInt("id");
		}
		
		String deleteSQL = "DELETE FROM humanity_weekly_project4.worker WHERE id=?";
		PreparedStatement preparedStatement2 = conn.prepareStatement(deleteSQL);
		preparedStatement2.setInt(1, id);
		// execute delete SQL stetement
		preparedStatement2.executeUpdate();
		
		//System.out.println(students);
	}
	
	public void deleteStudent(String firstName, String lastName) throws SQLException {
		String selectSQL = "SELECT id FROM humanity_weekly_project4.student WHERE firstName = ? and lastName = ?";
		PreparedStatement preparedStatement1 = conn.prepareStatement(selectSQL);
		preparedStatement1.setString(1, firstName);
		preparedStatement1.setString(2, lastName);
		ResultSet rs = preparedStatement1.executeQuery();
		int id = -1;
		while (rs.next()) {
			id = rs.getInt("id");
		}
		
		String deleteSQL = "DELETE FROM humanity_weekly_project4.student WHERE id=?";
		PreparedStatement preparedStatement2 = conn.prepareStatement(deleteSQL);
		preparedStatement2.setInt(1, id);
		// execute delete SQL stetement
		preparedStatement2.executeUpdate();
	}
	
	public void insertStudent(String firstName, String lastName, String faculty) throws SQLException {
		String insertTableSQL = "INSERT INTO humanity_weekly_project4.student"
				+ "(id, firstName, lastName, faculty) VALUES"
				+ "(null,?,?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
		preparedStatement.setString(1, firstName);
		preparedStatement.setString(2, lastName);
		preparedStatement.setString(3, faculty);
		// execute insert SQL stetement
		preparedStatement.executeUpdate();
		//System.out.println();
	}
	
	public void insertWorker(String firstName, String lastName, float weekSalary, int workHourtoDay) throws SQLException {
		String insertTableSQL = "INSERT INTO humanity_weekly_project4.worker"
				+ "(id, firstName, lastName, weekSalary, workHourtoDay ) VALUES"
				+ "(null,?,?,?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
		preparedStatement.setString(1, firstName);
		preparedStatement.setString(2, lastName);
		preparedStatement.setFloat(3, weekSalary);
		preparedStatement.setFloat(4, workHourtoDay);
		// execute insert SQL stetement
		preparedStatement.executeUpdate();
		//System.out.println();
	}
	
	public ArrayList<Student> students() throws SQLException {
		
		ArrayList<Student> array1 = new ArrayList<Student>();
		String selectSQL = "SELECT * FROM humanity_weekly_project4.student";
		PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
		
		ResultSet rs = preparedStatement.executeQuery(selectSQL );
		while (rs.next()) {
			String id = rs.getString("id");
			String firstName = rs.getString("firstName");	
			String lastName = rs.getString("lastName");
			String faculty = rs.getString("faculty");
			array1.add(new Student(firstName, lastName,faculty));
			System.out.println(id + " " + firstName + " " + lastName + " " + faculty);
			
		}
		System.out.print("\n");
		return array1 ;
	}
	
	public ArrayList<Worker> workers() throws SQLException {
		ArrayList<Worker> array2 = new ArrayList<Worker>();
		String selectSQL = "SELECT * FROM humanity_weekly_project4.worker";
		PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
		
		ResultSet rs = preparedStatement.executeQuery(selectSQL );
		while (rs.next()) {
			String id = rs.getString("id");
			String firstName = rs.getString("firstName");	
			String lastName = rs.getString("lastName");
			float weekSalary = rs.getFloat("weekSalary");
			int workHourtoDay = rs.getInt("workHourtoDay");
			array2.add(new Worker(firstName, lastName,weekSalary,workHourtoDay ));
			System.out.println(id + " " + firstName + " " + lastName + " " + weekSalary + " " + workHourtoDay);
			
		}
		return array2 ;
	}

	public static void main (String [] args) {
		//Scanner sc = new Scanner(System.in);
		TheHuman hum =new TheHuman();
		//hum.students = hum.students();
		//hum.workers = hum.workers();
		/*try {
			System.out.println(hum.students());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//System.out.println(hum.workers().size());
		//hum.insertStudent("Anna", "Karenina", "AS999");
		//System.out.println(hum.students().size());
		//hum.insertWorker("Andreas", "Akalyptos", 12, 6);
		//System.out.println(hum.workers().size());
		
		/*try {
			hum.deleteWorker("Tzeni", "Mpotsi");
			System.out.println(hum.workers());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*try {
			hum.deleteStudent("Aggeliki" , "Eleftheriou");
			System.out.println(hum.students());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		boolean running=true;
		while(running) {
			Scanner sc1 = new Scanner(System.in);
			System.out.println("What do you want to do?");
			System.out.println("1.Show Students? ");
			System.out.println("2.Show Workers? ");
			System.out.println("3.Create a new student? ");
			System.out.println("4.Create a new worker? ");
			System.out.println("5.Delete a new student?");
			System.out.println("6.Delete a new worker?");
			System.out.println("Enter a number from 1 to 6: ");
			String enter = sc1.nextLine();
			
			
				try {
						//read students
						if(enter.equals("1")) {
							hum.students();
						}
						//read workers
						else if(enter.equals("2")) {
							hum.workers();
						}
						//create new student
						else if(enter.equals("3")) {
							System.out.println("Give me first name: ");
							String firstName = sc1.nextLine();
							System.out.println("Give me last name: ");
							String lastName = sc1.nextLine();
							System.out.println("Give me faculty: ");
							String facu = sc1.nextLine();
							hum.insertStudent(firstName, lastName, facu);
						}
						//create new worker
						else if(enter.equals("4")) {
							System.out.println("Give me first name: ");
							String firstName = sc1.nextLine();
							System.out.println("Give me last name: ");
							String lastName = sc1.nextLine();
							System.out.println("Give me weekSalary: ");
							float weekSalary = sc1.nextFloat();
							System.out.println("Give me workHourtoDay: ");
							int workHourtoDay = sc1.nextInt();
							hum.insertWorker(firstName, lastName, weekSalary, workHourtoDay);
						}
						//delete a student
						else if(enter.equals("5")) {
							System.out.println("Give me first name: ");
							String firstName = sc1.nextLine();
							System.out.println("Give me last name: ");
							String lastName = sc1.nextLine();
							hum.deleteStudent(firstName, lastName);
							
						}
						//delete a worker
						else if(enter.equals("6")) {
							System.out.println("Give me first name: ");
							String firstName = sc1.nextLine();
							System.out.println("Give me last name: ");
							String lastName = sc1.nextLine();
							hum.deleteWorker(firstName, lastName);
						}	
						else {
							System.out.println("Invalid input");
							continue;
						}
						System.out.println("Do you want to continue (Y/N):");
						String answer=sc1.next();
						if(answer.equalsIgnoreCase("N")) {
							System.out.println("BYe");
							running=false;
							
						}

					}
					
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
	
		
		}
		}
	}


