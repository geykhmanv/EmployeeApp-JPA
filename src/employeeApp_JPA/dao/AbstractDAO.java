package employeeApp_JPA.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractDAO {

	private EntityManagerFactory emf = null;
	protected EntityManager em = null;
	private final String PERSISTENCE_UNIT_NAME = "employeeApp_JPA";
	
	protected void connectToDB() {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
	}//protected void connectToDB() 
	
	protected void dispose() {
		em.close();
		emf.close();
	}//protected void dispose()
	
}//public class AbstractDAO 
