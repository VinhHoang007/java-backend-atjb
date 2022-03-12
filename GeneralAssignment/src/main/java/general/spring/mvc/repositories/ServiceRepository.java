package general.spring.mvc.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import general.spring.mvc.entities.Services;

@Repository
public class ServiceRepository {
	@Autowired
	SessionFactory sf;

	public void saveService(Services post) {
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public List<Services> getAllServiceList() {
		Session session = sf.openSession();
		List<Services> lstEntity = null;

		try {
			String hSql = "from Services";
			Query<Services> query = session.createQuery(hSql, Services.class);
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

	public void deleteService(String serID) {
		Session session = sf.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Services mv = (Services) session.get(Services.class, serID);
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
		} catch (Exception se) {
			se.printStackTrace();
		} finally {
			session.close();
		}
	}

	public Services findServicerByID(String comID) {
		Session session = sf.openSession();

		Services mv = null;
		try {
			mv = (Services) session.get(Services.class, comID);

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception se) {
			se.printStackTrace();
		} finally {
			session.close();
		}
		return mv;
	}
	
	public void updateService(Services updateService) {
		Session session = sf.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
					
			if (updateService != null) {
				session.update(updateService);
				tx.commit();
			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}catch (Exception se) {
			se.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	
	//Dem So Luong record computer cho viec paging
		public int countService() {
			Session session = sf.openSession();
			int count = 0;

			try {
				String hSql = "from Services";
				Query<Services> query = session.createQuery(hSql, Services.class);
				List<Services> lst = query.getResultList();
				count = lst.size();

			} catch (HibernateException e) {
				e.printStackTrace();
			} finally {
				session.close();
			}

			return count;

		}

		//Tim Kiem Computer Theo Name
		public List<Services> searchService(String serviceName) {
			Session session = sf.openSession();
			List<Services> lstEntity = null;

			try {
				String hSql = "from Services where serviceName=:serviceName";
				Query<Services> query = session.createQuery(hSql, Services.class);
				query.setParameter("serviceName", serviceName);
		
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
		
		//Phan Trang
		public List<Services> getPagingList(int index, int numberOfRow) {
			Session session = sf.openSession();
			List<Services> lstEntity = null;

			try {
				String hSql = "select * from Services \r\n" + "ORDER BY ServiceID \r\n"
						+ "OFFSET :index ROWS  FETCH FIRST :numberOfRow ROWS ONLY";
				NativeQuery<Services> query = session.createNativeQuery(hSql, Services.class);
				query.setParameter("index", (index - 1) * numberOfRow);
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
