package employeeApp_JPA.dao;
import employeeApp_JPA.entities.Employee;
import java.util.List;

public class EmployeeServices extends AbstractDAO implements EmployeeInterface {

	@Override
	public int addEmployee(Employee employee) {
		int row = 0;
		
		//connect
		connectToDB();
		
		//execute
		try {
			em.getTransaction().begin();
			em.persist(employee);
			em.getTransaction().commit();
			row = 1;
		}catch(Exception e) {
			row = 0;
		}finally {
			//close
			dispose();
		}
		
		return row;
	}//public int addEmployee(Employee employee)

	@Override
	public Employee getEmployeeById(Integer id) {
		
		connectToDB();
		
		Employee foundEmployee = null;
		try {
			em.getTransaction().begin();
			foundEmployee = em.find(Employee.class, id);
			em.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			//close
			dispose();
		}
		
		return foundEmployee;
	}//public Employee getEmployeeById(Integer id)

	@Override
	public int updateEmployeeById(Integer id, Employee employee) {
		int row = 0;
		
		connectToDB();
		try {
			em.getTransaction().begin();
			Employee employeeFound = em.find(Employee.class, id);
			employeeFound.setFname(employee.getFname());
			employeeFound.setLname(employee.getLname());
			employeeFound.setSalary(employee.getSalary());
			em.merge(employeeFound);
			em.getTransaction().commit();
			row = 1;
		}catch(Exception e) {
			row = 0;
		}finally {
			//close
			dispose();
		}
		
		return row;
	}//public int updateEmployeeById(Integer id, Employee employee)

	@Override
	public Employee deleteEmployeeById(Integer id) {
		
		connectToDB();
		
		Employee foundEmployee = null;
		try {
			em.getTransaction().begin();
			foundEmployee = em.find(Employee.class, id);
			em.remove(foundEmployee);
			em.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			//close
			dispose();
		}
		
		return foundEmployee;

	}//public Employee deleteEmployeeById(Integer id)

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = null;
		connectToDB();
		try {
			em.getTransaction().begin();
			employees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
			em.getTransaction().commit();
		}catch(Exception e) {
			employees = null;
			e.printStackTrace();
		}
		dispose();
		return employees;
	}//public List<Employee> getAllEmployees()

}//public class EmployeeServices implements EmployeeInterface 
