package employeeApp_JPA.dao;

import java.util.List;
import employeeApp_JPA.entities.Employee;

public interface EmployeeInterface {
	
	public int addEmployee(Employee employee); 
	public Employee getEmployeeById(Integer id);
	public int updateEmployeeById(Integer id, Employee employee);
	public Employee deleteEmployeeById(Integer id);
	public List<Employee> getAllEmployees();
	
}//public interface EmployeeInterface
