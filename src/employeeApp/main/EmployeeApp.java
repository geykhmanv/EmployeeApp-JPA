package employeeApp.main;

import java.util.List;

import employeeApp_JPA.dao.EmployeeServices;
import employeeApp_JPA.entities.Employee;

public class EmployeeApp {

	static EmployeeServices employeeServices = new EmployeeServices();
	static Employee employee;
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Employee App");
		int operation = 5;
		employee = new Employee(4, "Mary", "Williams", 100.00);
		
		switch(operation) {
			case 1:
				registerEmployee(employee);
				break;
			case 2:
				showEmployeeById();
				break;
			case 3:
				editEmployeeById();
				break;
			case 4:
				removeEmployeeById();
				break;
			case 5:
				showAllEmployees();
				break;
			case 6:
				exitApp();
				break;
			default:
				break;
		}//switch

		
	}//public static void main(String[] args)

	private static void exitApp() {
		System.out.println("Goodbye");
	}//private static void exitApp()

	private static void showAllEmployees() {
		List<Employee> employeeList = employeeServices.getAllEmployees();
		if(employeeList != null) {
			System.out.println(employeeList);
		}else {System.out.println("No Employees");}
		
	}//private static void showAllEmployees()

	private static void removeEmployeeById() {
		Employee employee = employeeServices.deleteEmployeeById(1);
		if(employee != null) {
			System.out.println("Removed " + employee);
		}else {System.out.println("Employee Not Found"); }
	}//private static void removeEmployeeById()

	private static void editEmployeeById() {
		employee = new Employee(1, "Nick", "Smith", 150.00);
		//employee = new Employee(2, "Josh", "Doe", 700.00);
		int result = employeeServices.updateEmployeeById(1, employee);
		System.out.println(result==1 ? "Employee updated" : "Employee not found");
	}//private static void editEmployeeById()

	private static void showEmployeeById() {
		Employee employee = employeeServices.getEmployeeById(1);
		if(employee != null) {
			System.out.println(employee);
		}else {
			System.out.println("Employee Not found");
		}
		
	}//private static void showEmployeeById()

	private static void registerEmployee(Employee newEmployee) {
		int result = employeeServices.addEmployee(newEmployee);
		System.out.println(result==1 ? "Employee Registered" : "Employee Not Registered" );
	}//private static void registerEmployee()

}//public class EmployeeApp
