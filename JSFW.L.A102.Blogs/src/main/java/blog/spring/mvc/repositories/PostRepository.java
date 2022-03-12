package blog.spring.mvc.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.spring.mvc.entities.PostEntity;

@Repository
public class PostRepository {

	@Autowired
	SessionFactory sf;

	public void savePost(PostEntity post) {
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			// check validate
			if (post != null) {
				session.save(post);
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

	public List<PostEntity> getPostListByAccount(int authorID) {
		Session session = sf.openSession();
		List<PostEntity> lstEntity = null;

		try {
			String hSql = "from Posts where authorID= :authorID";
			Query<PostEntity> query = session.createQuery(hSql, PostEntity.class);
			query.setParameter("authorID", authorID);
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

	public List<PostEntity> getAllPostList() {
		Session session = sf.openSession();
		List<PostEntity> lstEntity = null;

		try {
			String hSql = "from Posts";
			Query<PostEntity> query = session.createQuery(hSql, PostEntity.class);
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

	public int countPosts() {
		Session session = sf.openSession();
		int count = 0;

		try {
			String hSql = "from Posts";
			Query<PostEntity> query = session.createQuery(hSql, PostEntity.class);
			List<PostEntity> lst = query.getResultList();
			count = lst.size();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return count;

	}

	public void deletePost(int theId) {
		Session session = sf.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			PostEntity mv = (PostEntity) session.get(PostEntity.class, theId);
			if (mv != null) {
				session.delete(mv);
				tx.commit();
			} else {
				System.out.println("Data Khong Ton Tai");
			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void updatePost(PostEntity postEntity) {
		Session session = sf.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			if (postEntity != null) {
				session.update(postEntity);
				tx.commit();
			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public PostEntity getPostEntity(int postID) {
		Session session = sf.openSession();
		try {

			PostEntity post = (PostEntity) session.get(PostEntity.class, postID);

			if (post == null) {
				System.out.println("Khong Ton Tai Du Lieu!");
			} else {
				return post;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}

	public List<PostEntity> searchPost(int authorID, String title, String status) {
		Session session = sf.openSession();
		List<PostEntity> lstEntity = null;

		try {
			String hSql = "from Posts where authorID= :authorID and title like :title and status= :status";
			Query<PostEntity> query = session.createQuery(hSql, PostEntity.class);
			query.setParameter("authorID", authorID);
			query.setParameter("title", "%" + title + "%");
			query.setParameter("status", status);
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

//	public List<PostEntity> getPagingList(int page, int totalRecod) {
//	Session session = sf.openSession();
//	List<PostEntity> lst = new ArrayList<PostEntity>();
//	Criteria criteria = session.createCriteria(PostEntity.class);
//	criteria.setFirstResult((page - 1) * totalRecod);
//	criteria.setMaxResults(totalRecod);
//	lst = criteria.list();
//
//	return lst;
//}

	public List<PostEntity> getPagingList(int index, int numberOfRow) {
		Session session = sf.openSession();
		List<PostEntity> lstEntity = null;

		try {
			String hSql = "select * from Posts \r\n"
					+ "ORDER BY title \r\n"
					+ "OFFSET :index ROWS  FETCH FIRST :numberOfRow ROWS ONLY";
			NativeQuery<PostEntity> query = session.createNativeQuery(hSql, PostEntity.class);
			query.setParameter("index", (index-1)*numberOfRow);
			query.setParameter("numberOfRow", numberOfRow);
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
