package modeldao;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.bean.Account;
import utils.HibernateUtils;

public class AccountDAO {
	
	public void insertAccount(Account emp) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			//check validate
			
			Set<ConstraintViolation<Account>> resultValidateCandiEntity = HibernateUtils.getValidator().validate(emp);

			if (resultValidateCandiEntity.size() > 0) {
				for (ConstraintViolation<Account> violation : resultValidateCandiEntity) {
					System.out.println(violation.getPropertyPath()+" = " +violation.getInvalidValue()+ ": " + violation.getMessage());
				}
				System.out.println("Insert Fail!!!");
			} else { 
				session.save(emp);
				tx.commit();
				System.out.println("Insert Success!!!");
			}	

			
		} catch (HibernateException e) {
			if (tx != null)
				e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
