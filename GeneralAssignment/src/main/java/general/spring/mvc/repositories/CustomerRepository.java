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

import general.spring.mvc.entities.Customer;

@Repository
public class CustomerRepository {
	@Autowired
	SessionFactory sf;

	public void saveCustomer(Customer post) {
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

	public Customer findCustomerByID(String custID) {
		Session session = sf.openSession();

		Customer mv = null;
		try {
			mv = (Customer) session.get(Customer.class, custID);

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception se) {
			se.printStackTrace();
		} finally {
			session.close();
		}
		return mv;
	}

	public List<Customer> getAllCustomerList() {
		Session session = sf.openSession();
		List<Customer> lstEntity = null;

		try {
			String hSql = "from Customer";
			Query<Customer> query = session.createQuery(hSql, Customer.class);
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

	public void deleteCustomer(String comID) {
		Session session = sf.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Customer mv = (Customer) session.get(Customer.class, comID);
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

	public void updateCustomer(Customer updateCustomer) {
		Session session = sf.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			if (updateCustomer != null) {
				session.update(updateCustomer);
				tx.commit();
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

	public List<Customer> getPagingList(int index, int numberOfRow) {
		Session session = sf.openSession();
		List<Customer> lstEntity = null;

		try {
			String hSql = "select * from Customer \r\n" + "ORDER BY customerID \r\n"
					+ "OFFSET :index ROWS  FETCH FIRST :numberOfRow ROWS ONLY";
			NativeQuery<Customer> query = session.createNativeQuery(hSql, Customer.class);
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
	
	public List<Object[]> getPagingListDetail(int index, int numberOfRow) {
		Session session = sf.openSession();
		List<Object[]> lstEntity = null;

		try {
			
			String hSql = "select kh.customerID,kh.customerName,sdm.computerID,m.position\r\n"
					+ ",m.status,sdm.dateOfUseComputer,sdm.timeBeginOfUseComputer,sdm.timeUseComputer\r\n"
					+ ",sddv.serviceID,sddv.dayOfUseService,sddv.timeOfUseService, sddv.quantity\r\n"
					+ "from Customer kh\r\n"
					+ "join ServiceUsage sddv on kh.customerID=sddv.customerID\r\n"
					+ "join ComputerUsage sdm on sdm.customerID=kh.customerID\r\n"
					+ "join Computer m on m.computerID=sdm.computerID\r\n"
					+ "join Services dv on dv.serviceID=sddv.serviceID\r\n"
					+ "order by kh.customerID\r\n"
					+ "OFFSET :index ROWS  FETCH FIRST :numberOfRow ROWS ONLY";
			Query query = session.createNativeQuery(hSql);
			query.setParameter("index", (index - 1) * numberOfRow);
			query.setParameter("numberOfRow", numberOfRow);
			lstEntity = query.getResultList();

			if (lstEntity.isEmpty()) {
				System.out.println("Khong Ton Tai Du Lieu!");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception se) {
			se.printStackTrace();
		}finally {
			session.close();
		}

		return lstEntity;

	}
	
	public List<Object[]> getTotalMoneyServiceDetail() {
		Session session = sf.openSession();
		List<Object[]> lstEntity = null;

		try {
			
			String hSql = "select kh.customerID,sum(dv.price*sddv.quantity) as Sum_Money_Services \r\n"
					+ "		from Customer kh\r\n"
					+ "		join ServiceUsage sddv on kh.customerID=sddv.customerID\r\n"
					+ "		join Services dv on dv.serviceID=sddv.serviceID\r\n"
					+ "		group by kh.customerID";
			Query query = session.createNativeQuery(hSql);
			lstEntity = query.getResultList();
			if (lstEntity.isEmpty()) {
				System.out.println("Khong Ton Tai Du Lieu!");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception se) {
			se.printStackTrace();
		}finally {
			session.close();
		}

		return lstEntity;

	}
	
	public int countCustomerDetail() {
		Session session = sf.openSession();
		int count = 0;

		try {
			String hSql = "select kh.customerID,kh.customerName,sdm.computerID,m.position\r\n"
					+ ",m.status,sdm.dateOfUseComputer,sdm.timeBeginOfUseComputer,sdm.timeUseComputer\r\n"
					+ ",sddv.serviceID,sddv.dayOfUseService,sddv.timeOfUseService, sddv.quantity\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "from Customer kh\r\n"
					+ "join ServiceUsage sddv on kh.customerID=sddv.customerID\r\n"
					+ "join ComputerUsage sdm on sdm.customerID=kh.customerID\r\n"
					+ "join Computer m on m.computerID=sdm.computerID\r\n"
					+ "join Services dv on dv.serviceID=sddv.serviceID";
	
			Query query = session.createQuery(hSql);
			List<Object[]> lst = query.getResultList();
			count = lst.size();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return count;

	}

	public int countCustomer() {
		Session session = sf.openSession();
		int count = 0;

		try {
			String hSql = "from Customer";
			Query<Customer> query = session.createQuery(hSql, Customer.class);
			List<Customer> lst = query.getResultList();
			count = lst.size();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return count;

	}

	public int countCustomerByName(String name) {
		Session session = sf.openSession();
		int count = 0;

		try {
			String hSql = "from Customer where customerName like :customerName";
			Query<Customer> query = session.createQuery(hSql, Customer.class);
			query.setParameter("customerName", "%" + name + "%");
			List<Customer> lst = query.getResultList();
			count = lst.size();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return count;

	}

	public List<Customer> searchCustomer(String customerName) {
		Session session = sf.openSession();
		List<Customer> lstEntity = null;

		try {
			String hSql = "from Customer where customerName like :customerName";
			Query<Customer> query = session.createQuery(hSql, Customer.class);
			query.setParameter("customerName", "%"+customerName+"%");
	
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
	
	public List<Object[]> searchCustomerDetail(String customerName) {
		Session session = sf.openSession();
		List<Object[]> lstEntity = null;

		try {
			String hSql = "select kh.customerID,kh.customerName,sdm.computerID,m.position\r\n"
					+ ",m.status,sdm.dateOfUseComputer,sdm.timeBeginOfUseComputer,sdm.timeUseComputer\r\n"
					+ ",sddv.serviceID,sddv.dayOfUseService,sddv.timeOfUseService, sddv.quantity\r\n"
					+ "from Customer kh\r\n"
					+ "join ServiceUsage sddv on kh.customerID=sddv.customerID\r\n"
					+ "join ComputerUsage sdm on sdm.customerID=kh.customerID\r\n"
					+ "join Computer m on m.computerID=sdm.computerID\r\n"
					+ "join Services dv on dv.serviceID=sddv.serviceID\r\n"
					+ "where kh.customerName like :customerName "
					+ "order by kh.customerID";
			Query query = session.createQuery(hSql);
			query.setParameter("customerName", "%"+customerName+"%");
	
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
