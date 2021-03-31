package application.model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class CashotSystem {
	
	private int ID;
	private String admin;
//	private ArrayList<Receipt> receipt;
	private static ArrayList<Employee> employees;
	
	
	public CashotSystem(){
		employees = new ArrayList<Employee>();
	}
	
	public void loadEmployees() throws IOException {
		//String employeeName, String userName, String employeePassword, int ID, boolean Admin
		String row;
		
		BufferedReader csvReader = new BufferedReader( new FileReader("data/employees.csv") );
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
			Employee tempEmployee = new Employee(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4]);
			addEmployee(tempEmployee);
			
		}
		
		csvReader.close();
	
	}
	
	public static void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public static String generateEmployeeString(){
		String str = "";
		for (Employee employee: employees){
			str += employee + "\n";
		}
		return str;
	}
}
