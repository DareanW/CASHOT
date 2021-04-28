
package application.model;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Employee class represents a Employee object which has an
 * employeeName,userName,employeePassword,ID,admin,trainiee,cashier, and an
 * arrayList.
 * 
 * @author Darean Wilde grl167 63678621
 * @author Jacob Shawver fww704 36242636
 * @author Majerus Sims hug180 79595196
 * @author Alexander Delgado tvh991 79595706
 *
 */
public class Employee {
	private String employeeName;
	private String userName;
	private String employeePassword;


	private int ID;

	private static ArrayList<Order> orders;
	private String admin;
	private String trainiee;
	private String cashier;
/**
	 * constructor for our employee object
	 * 
	 * @param employeeName
	 * @param userName
	 * @param employeePassword
	 * @param ID
	 * @param admin
	 * @param trainiee
	 * @param cashier
	 */
	public Employee(String employeeName, String userName, String employeePassword, int ID, String admin,
			String trainiee, String cashier) {
		this.employeeName = employeeName;
		this.userName = userName;
		this.employeePassword = employeePassword;
		this.ID = ID;
		Employee.orders = new ArrayList<Order>();
		this.admin = admin;
		this.trainiee = trainiee;
		this.cashier = cashier;
	}
/**
	 * returns the name of the employee
	 * 
	 * @return
	 */
	public String getEmployeeName() {
		return employeeName;
	}
/**
	 * setter for the employee name
	 * 
	 * @param employeeName
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


  /**
	 * returns the user name of the employee
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * setter for the userName
	 * 
	 * @param userName
	 */

	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * returns the password of the employee
	 * 
	 * @return
	 */

	public String getEmployeePassword() {
		return employeePassword;
	}

	/**
	 * setter for the employeePassword
	 * 
	 * @param employeePassword
	 */

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}


	/**
	 * returns the ID of the employee
	 * 
	 * @return
	 */

	public int getID() { // changed to static
		return ID;
	}


	/**
	 * setter for ID
	 * 
	 * @param iD
	 */

	public void setID(int iD) {
		ID = iD;
	}


  /**
	 * returns the orders
	 * 
	 * @return
	 */
	public static ArrayList<Order> getOrder() {
		return orders;
	}
/**
	 * setter for the order
	 * 
	 * @param order
	 */
	public void setOrder(ArrayList<Order> order) {
		Employee.orders = order;
	}


  /**
	 * adds an order to the Order arraylist
	 * 
	 * @param order
	 */
	public void addOrder(Order order) {
		orders.add(order);
	}


	/**
	 * returns an 8-digit number for the employee
	 * 
	 * @param userName
	 * @return
	 */

	public static int hashNum(String userName) {
		long num = 0;
		for (int i = 0; i < userName.length(); i++)
			num += userName.codePointAt(i);
		num *= 7;
		num *= 522;
		num *= 3;
		num *= 768546547;
		// System.out.println(num);
		// System.out.println(num % 100000000);
		if (num % 100000000 < 9999999)
			num += 10000000;
		int returnNum = (int) (num % 100000000);
		for (Employee employee : CashotSystem.getEmployees()) {
			if (returnNum == employee.getID()) {
				if (returnNum == 99999999)
					returnNum = 10000000;
				else
					returnNum++;
			}
			if (returnNum == employee.getID())
				returnNum++;
		}
		return returnNum;
	}

	public void add(ArrayList<Employee> employee) {

	}


	/**
	 * returns a string
	 */

	@Override
	public String toString() {
		return this.ID + " " + this.employeeName + " " + this.userName;
	}

	/**
	 * returns true or false if user is an admin or not
	 * 
	 * @return
	 */
	public String isAdmin() {
		return admin;
	}


	/**
	 * setter for the admin
	 * 
	 * @param admin
	 */

	public void setAdmin(String admin) {
		this.admin = admin;
	}


	/**
	 * returns true or false if user is traniee or not
	 * 
	 * @return
	 */

	public String getTrainiee() {
		return trainiee;
	}


	/**
	 * setter for the trainiee
	 * 
	 * @param trainiee
	 */

	public void setTrainiee(String trainiee) {
		this.trainiee = trainiee;
	}


	/**
	 * returns true or false if user is a cashier or not
	 * 
	 * @return
	 */

	public String getCashier() {
		return cashier;
	}


	/**
	 * setter for the cashier
	 * 
	 * @param cashier
	 */

	public void setCashier(String cashier) {
		this.cashier = cashier;
	}


	/**
	 * changes the employee to a admin or cashier depending on what the admin
	 * wants
	 * 
	 * @param id
	 * @param action
	 * @return
	 * @throws IOException
	 */

	public static String changeEmployeeStat(int id, String action) throws IOException {
		String idString = Integer.toString(id);
		int count = 0;
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("data/employees.csv"));

			StringBuffer buf = new StringBuffer();
			String line;


			for (Employee i : CashotSystem.getEmployees()) {
				while ((line = csvReader.readLine()) != null) {
					if (line.contains(idString)) {
						String[] temp = line.split(",");
						if (action.equals("promoteToAdmin")) {
							i.employeeName = temp[0];
							i.userName = temp[1];
							i.employeePassword = temp[2];
							i.ID = Integer.parseInt(temp[3]);
							i.admin = "TRUE";
							i.cashier = "FALSE";
							i.trainiee = "FALSE";
							count++;
						} else {
							i.employeeName = temp[0];
							i.userName = temp[1];
							i.employeePassword = temp[2];
							i.ID = Integer.parseInt(temp[3]);
							i.trainiee = "FALSE";
							i.cashier = "TRUE";
							i.admin = "FALSE";
							count++;
						}
						String newLine = i.getEmployeeName() + "," + i.getUserName() + "," + i.getEmployeePassword()
								+ "," + i.getID() + "," + i.isAdmin() + "," + i.getTrainiee() + "," + i.getCashier()
								+ "\n";
						buf.append(newLine);

					} else {
						buf.append(line);
						buf.append('\n');
					}

				}

				BufferedWriter csvWriter = new BufferedWriter(new FileWriter("data/employees.csv", false));

				String output = buf.toString();
				csvWriter.write(output);

				csvReader.close();
				csvWriter.close();
				// System.out.println("test");
			}
		} catch (Exception e) {
		} // try
		if (count == 0)// meaning no employee with that ID was found so let the
						// user know
			return "FALSE";

		return "TRUE";

	}
/**
	 * removes the specifed employees from the file
	 * 
	 * @param id
	 * @return
	 * @throws IOException
	 */
	public static String removeEmployFromFile(int id) throws IOException {
		String idString = Integer.toString(id);

		BufferedReader csvReader = new BufferedReader(new FileReader("data/employees.csv"));

		StringBuffer buf = new StringBuffer();
		String line;
		int count = 0;
		try {
			for (Employee i : CashotSystem.getEmployees()) {
				while ((line = csvReader.readLine()) != null) {
					String[] temp = line.split(",");
					if (!line.contains(idString)) {
						i.employeeName = temp[0];
						i.userName = temp[1];
						i.employeePassword = temp[2];
						i.ID = Integer.parseInt(temp[3]);
						i.admin = temp[4];
						i.cashier = temp[6];
						i.trainiee = temp[5];


						String newLine = i.getEmployeeName() + "," + i.getUserName() + "," + i.getEmployeePassword()
								+ "," + i.getID() + "," + i.isAdmin() + "," + i.getTrainiee() + "," + i.getCashier()
								+ "\n";
						buf.append(newLine);

						count++;
					}
				}
			} // for loop
			BufferedWriter csvWriter = new BufferedWriter(new FileWriter("data/employees.csv", false));

			String output = buf.toString();
			csvWriter.write(output);

			csvReader.close();
			csvWriter.close();

		} catch (Exception e) {
		}
		if (count == 0)// meaning no employee with that ID was found so let the
						// user know
			return "FALSE";

		return "TRUE";


	}

}
