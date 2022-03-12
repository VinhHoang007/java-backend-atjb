package cms.spring.mvc.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cms.spring.mvc.entities.Content;

@Repository
public class ContentRepository {
	@Autowired
	SessionFactory sf;

	public List<Content> getAllContentList() {
		Session session = sf.openSession();
		List<Content> lstEntity = null;

		try {
			String hSql = "from Content";
			Query<Content> query = session.createQuery(hSql, Content.class);
			lstEntity = query.getResultList();
			if (lstEntity.isEmpty()) {
				System.out.println("Khong Ton Tai Du Lieu!");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return lstEntity;
	}

	public void saveContent(Content cont) {
		
			Session session = sf.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();

				// check validate
				if (cont != null) {
					session.save(cont);
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
