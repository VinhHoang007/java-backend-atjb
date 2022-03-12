package modeldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.bean.Employee;
import utils.ConnectionUtils;
import utils.HibernateUtils;

public class EmployeeDAO {
	
//	public ArrayList<Employee> getEmployee() {
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		Connection conn = null;
//		ArrayList<Employee> lstEmp = new ArrayList<Employee>();
//		Employee emp;
//		try {
//			
//			conn = ConnectionUtils.getConnection();
//			
//			String sql = "select * from Employee";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				emp = new Employee();
//				emp.setEmployeeID(rs.getInt(1));
//				emp.setFirstName(rs.getString(2));
//				emp.setLastName(rs.getString(3));
//				emp.setGender(rs.getInt(4));
//				emp.setDob(LocalDate.parse(rs.getString(5)));
//				emp.setPhone(rs.getString(6));
//				emp.setAddress(rs.getString(7));
//				emp.setDeptName(rs.getString(8));
//				emp.setRemark(rs.getString(9));
//				lstEmp.add(emp);
//			}
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (conn != null) {
//					ConnectionUtils.closeConnection(conn);
//				}
//				
//			} catch (SQLException se2) {
//				se2.printStackTrace();
//			}
//		}
//		return lstEmp;
//	}
	
	public ArrayList<Employee> getEmployee() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		List<Employee> data = null;
		try {
			String hSql = "from Employee";
			Query<Employee> query = session.createQuery(hSql, Employee.class);
			data = query.getResultList();
			

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return (ArrayList<Employee>) data;
	}
	
	public Employee getEmployeeByAccount(String account) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		Employee emp = null;
		try {
			
			conn = ConnectionUtils.getConnection();
			
			String sql = "select * from Employee e\r\n"
					+ "where e.EmployeeID in (select a.EmployeeID from Account a where a.account = ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				emp = new Employee();
				emp.setEmployeeID(rs.getInt("EmployeeID"));
				emp.setFirstName(rs.getString("FirstName"));
				emp.setLastName(rs.getString("LastName"));
				emp.setGender(rs.getInt("gender"));
				emp.setDob(LocalDate.parse(rs.getString("Date_of_birth")));
				emp.setPhone(rs.getString("phone"));
				emp.setAddress(rs.getString("address"));
				emp.setDeptName(rs.getString("Department"));
				emp.setRemark(rs.getString("Remark"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					ConnectionUtils.closeConnection(conn);
				}
				
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
		return emp;
	}
	
//	public Employee getEmployeeByID(int id) {
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		Connection conn = null;
//		Employee emp = null;
//		try {
//			
//			conn = ConnectionUtils.getConnection();
//			
//			String sql =  "select * from Employee where EmployeeID = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, id);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				emp = new Employee();
//				emp.setEmployeeID(rs.getInt(1));
//				emp.setFirstName(rs.getString(2));
//				emp.setLastName(rs.getString(3));
//				emp.setGender(rs.getInt(4));
//				emp.setDob(LocalDate.parse(rs.getString(5)));
//				emp.setPhone(rs.getString(6));
//				emp.setAddress(rs.getString(7));
//				emp.setDeptName(rs.getString(8));
//				emp.setRemark(rs.getString(9));
//			}
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (conn != null) {
//					ConnectionUtils.closeConnection(conn);
//				}
//				
//			} catch (SQLException se2) {
//				se2.printStackTrace();
//			}
//		}
//		return emp;
//	}
	public Employee getEmployeeByID(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {

			Employee doc = (Employee) session.get(Employee.class, id);
			
			if (doc == null) {
				System.out.println("Khong Ton Tai Du Lieu!");
			}else {
				return doc;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}

//	public void insertEmp(Employee emp) {
//		PreparedStatement pstmt = null;
//		Connection conn = null;
//		try {
//			
//			conn = ConnectionUtils.getConnection();
//			
//			String sql = "	insert into Employee(first_name,last_name,gender,date_of_birth,phone,address"
//					+ ",deparment_name,remark) values(?,?,?,?,?,?,?,?) ";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, emp.getFirstName());
//			pstmt.setString(2, emp.getLastName());
//			pstmt.setInt(3, emp.getGender());
//			pstmt.setString(4, emp.getDob().toString());
//			pstmt.setString(5, emp.getPhone());
//			pstmt.setString(6, emp.getAddress());
//			pstmt.setString(7, emp.getDeptName());
//			pstmt.setString(8, emp.getRemark());
//			int checkInsert = pstmt.executeUpdate();
//			
//			if(checkInsert>0) {
//				System.out.println("Insert Sucess!!!");
//			}
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} finally {
//			try {
//
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (conn != null) {
//					ConnectionUtils.closeConnection(conn);
//				}
//				
//			} catch (SQLException se2) {
//				se2.printStackTrace();
//			}
//		}
//
//	}
	
	public void insertEmp(Employee emp) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			//check validate
			
			Set<ConstraintViolation<Employee>> resultValidateCandiEntity = HibernateUtils.getValidator().validate(emp);

			if (resultValidateCandiEntity.size() > 0) {
				for (ConstraintViolation<Employee> violation : resultValidateCandiEntity) {
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

//	public void updateEmp(Employee emp) {
//		PreparedStatement pstmt = null;
//		Connection conn = null;
//		try {
//			
//			conn = ConnectionUtils.getConnection();
//			
//			String sql = "	update Employee set first_name = ? ,last_name = ? ,gender = ?,date_of_birth=?"
//					+ ",phone = ?,address =? ,deparment_name =?,remark =? where employee_id =?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, emp.getFirstName());
//			pstmt.setString(2, emp.getLastName());
//			pstmt.setInt(3, emp.getGender());
//			pstmt.setString(4, emp.getDob().toString());
//			pstmt.setString(5, emp.getPhone());
//			pstmt.setString(6, emp.getAddress());
//			pstmt.setString(7, emp.getDeptName());
//			pstmt.setString(8, emp.getRemark());
//			pstmt.setInt(9, emp.getEmployeeID());
//			int checkInsert = pstmt.executeUpdate();
//			
//			if(checkInsert>0) {
//				System.out.println("Update Sucess!!!");
//			}
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} finally {
//			try {
//
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (conn != null) {
//					ConnectionUtils.closeConnection(conn);
//				}
//				
//			} catch (SQLException se2) {
//				se2.printStackTrace();
//			}
//		}
//	}
	
	public void updateEmp(Employee emp) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Employee can = (Employee) session.get(Employee.class, emp.getEmployeeID());

			if (can != null) {
				can.setFirstName(emp.getFirstName());
				can.setLastName(emp.getLastName());
				can.setAddress(emp.getAddress());
				can.setPhone(emp.getPhone());
				can.setDeptName(emp.getDeptName());
				can.setDob(emp.getDob());;
				can.setRemark(emp.getRemark());
				
				session.update(can);
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
	
//	public void deleteEmp(int id) {
//		PreparedStatement pstmt = null;
//		Connection conn = null;
//		try {
//			
//			conn = ConnectionUtils.getConnection();
//			
//			String sql = "delete employee where employee_id =?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, id);
//			
//			int checkDelete = pstmt.executeUpdate();
//			
//			if(checkDelete>0) {
//				System.out.println("Delete Sucess!!!");
//			}
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} finally {
//			try {
//
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (conn != null) {
//					ConnectionUtils.closeConnection(conn);
//				}
//				
//			} catch (SQLException se2) {
//				se2.printStackTrace();
//			}
//		}
//	}
	public void deleteEmp(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Employee mv = (Employee) session.get(Employee.class, id);
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
}
