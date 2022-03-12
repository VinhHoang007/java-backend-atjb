package blog.spring.mvc.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.spring.mvc.entities.CommentEntity;

@Repository
public class CommentRepository {
	@Autowired
	SessionFactory sf;
	
	public void saveComments(CommentEntity cmt) {
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			// check validate
			if (cmt != null) {
				session.save(cmt);
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

	public List<CommentEntity> getAllComment() {
		Session session = sf.openSession();
		List<CommentEntity> lstEntity = null;

		try {
			String hSql = "from Comments";
			Query<CommentEntity> query = session.createQuery(hSql, CommentEntity.class);
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
	
	public List<CommentEntity> getCommentByPostID(int postID) {
		Session session = sf.openSession();
		List<CommentEntity> lstEntity = null;

		try {
			String hSql = "from Comments where postID = :postID";
			Query<CommentEntity> query = session.createQuery(hSql, CommentEntity.class);
			query.setParameter("postID", postID);
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
}
