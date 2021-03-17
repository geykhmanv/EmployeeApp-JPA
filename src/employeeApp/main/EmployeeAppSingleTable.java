package employeeApp.main;
import employeeApp_JPA.dao.AbstractDAO;
import employeeApp_JPA.entities.NonTeachingStaff;
import employeeApp_JPA.entities.Staff;
import employeeApp_JPA.entities.TeachingStaff;

public class EmployeeAppSingleTable extends AbstractDAO {

	public static void main(String[] args) {
		System.out.println("STAFF SINGLE TABLE SAMPLE");
		testRegisterStaff();
		System.out.println("Goodbye");

	}//public static void main(String[] args)

	private static void testRegisterStaff() {
		
		Staff staff = new Staff(11, "Mary");
		TeachingStaff teachingStaff = new TeachingStaff(112, "John", "Developer", "Java");
		NonTeachingStaff nonTeachingStaff = new NonTeachingStaff(113, "Bill", "Admin");
		
		connectToDB();
		em.getTransaction().begin();
		
		em.persist(staff);
		em.persist(teachingStaff);
		em.persist(nonTeachingStaff);
		
		em.getTransaction().commit();
		dispose();
		
	}//private static void testRegisterStaff()

}//public class EmployeeAppSingleTable
