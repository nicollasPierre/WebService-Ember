package controle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoDB {

	private static EntityManagerFactory 
			entityManagerFactory;
	public static EntityManager manager;
	
	static {
		entityManagerFactory = 
				Persistence.createEntityManagerFactory("persistencia");
		manager = entityManagerFactory.createEntityManager();
	}
	
}
