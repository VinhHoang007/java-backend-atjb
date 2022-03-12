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

import general.spring.mvc.entities.Computer;

@Repository
public class ComputerRepository {
	@Autowired
	SessionFactory sf;
	
	//Luu Computer
	public void saveComputer(Computer post) {
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

	//Lay Tat ca Danh sach computer
	public List<Computer> getAllComputerList() {
		Session session = sf.openSession();
		List<Computer> lstEntity = null;

		try {
			String hSql = "from Computer";
			Query<Computer> query = session.createQuery(hSql, Computer.class);
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
	
	public List<Computer> getComputerListAvailable() {
		Session session = sf.openSession();
		List<Computer> lstEntity = null;

		try {
			String hSql = "from Computer where status like :status";
			Query<Computer> query = session.createQuery(hSql, Computer.class);
			query.setParameter("status", "Available");
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


	//Delete computer
	public void deleteComputer(int comID) {
		Session session = sf.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Computer mv = (Computer) session.get(Computer.class, comID);
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
	
	//Tim kiem Computer theo ID
	public Computer findComputerByID(int comID) {
		Session session = sf.openSession();

		Computer mv = null;
		try {
			mv = (Computer) session.get(Computer.class, comID);

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception se) {
			se.printStackTrace();
		} finally {
			session.close();
		}
		return mv;
	}
	
	//Update Customer
	public void updateComputer(Computer updateComputer) {
		Session session = sf.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
					
			if (updateComputer != null) {
				session.update(updateComputer);
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
	public int countComputer() {
		Session session = sf.openSession();
		int count = 0;

		try {
			String hSql = "from Computer";
			Query<Computer> query = session.createQuery(hSql, Computer.class);
			List<Computer> lst = query.getResultList();
			count = lst.size();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return count;

	}

	//Tim Kiem Computer Theo Name
	public List<Computer> searchComputer(String status) {
		Session session = sf.openSession();
		List<Computer> lstEntity = null;

		try {
			String hSql = "from Computer where status=:status";
			Query<Computer> query = session.createQuery(hSql, Computer.class);
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
	
	//Phan Trang
	public List<Computer> getPagingList(int index, int numberOfRow) {
		Session session = sf.openSession();
		List<Computer> lstEntity = null;

		try {
			String hSql = "select * from Computer \r\n" + "ORDER BY computerID \r\n"
					+ "OFFSET :index ROWS  FETCH FIRST :numberOfRow ROWS ONLY";
			NativeQuery<Computer> query = session.createNativeQuery(hSql, Computer.class);
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
