package utils;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory sessionFactory;
	private static ValidatorFactory validatorFactory;
	static {
		// Create a new Configuration object
		Configuration cfg = new Configuration();
		cfg.configure();
		// Get the SessionFactory object from Configuration
		if (sessionFactory == null) {
			sessionFactory = cfg.buildSessionFactory();
		}
		validatorFactory = Validation.buildDefaultValidatorFactory();
	}
	
	public static Session getSession() {
		return sessionFactory.openSession();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Validator getValidator() {
		return validatorFactory.getValidator();
	}
	
	

}


