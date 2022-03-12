package blog.spring.mvc.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.spring.mvc.entities.UserEntity;

@Repository
public class UserRepository {
	@Autowired
	SessionFactory sf;

	public UserEntity findOne(String username) {
		Session session = sf.openSession();
		UserEntity result = null;
		
		try {
			String strHql = "FROM Users where userName =:username";

			Query<UserEntity> hql = session.createQuery(strHql, UserEntity.class);
			hql.setParameter("username", username);
			List<UserEntity> lst = hql.getResultList();
			if(lst.isEmpty()) {
				result = null;
			}else {
				result = lst.get(0);
			}			
		} catch (Exception se) {
			se.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	public void saveUsers(UserEntity user) {
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			// check validate
			if (user != null) {
				session.save(user);
				tx.commit();
				System.out.println("Insert Success!!!");
			} else {
				System.out.println("Insert Fail!!!");
			}

		} catch (HibernateException e) {
			if (tx != null)
				e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
