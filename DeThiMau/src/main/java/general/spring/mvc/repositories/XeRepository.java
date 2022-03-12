package general.spring.mvc.repositories;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import general.spring.mvc.entities.Xe;
@Repository
public class XeRepository {
	@Autowired
	SessionFactory sf;
	
	public void saveXe(Xe post) {
		Session session = sf.openSession();
		try {
			session.beginTransaction();

			if (post != null) {
				session.save(post);
				session.getTransaction().commit();
			} else {
				System.out.println("Insert Fail!!!");
			}

		} catch (HibernateException e) {
				e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
