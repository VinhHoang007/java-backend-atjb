package modeldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import model.bean.Employee;
import utils.ConnectionUtils;

public class EmployeeDAO {
	public ArrayList<Employee> getEmployee() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		ArrayList<Employee> lstEmp = new ArrayList<Employee>();
		Employee emp;
		try {
			
			conn = ConnectionUtils.getConnection();
			
			String sql = "select * from Employee";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				emp = new Employee();
				emp.setEmployeeID(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setGender(rs.getInt(4));
				emp.setDob(LocalDate.parse(rs.getString(5)));
				emp.setPhone(rs.getString(6));
				emp.setAddress(rs.getString(7));
				emp.setDeptName(rs.getString(8));
				emp.setRemark(rs.getString(9));
				lstEmp.add(emp);
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
		return lstEmp;
	}
	
	public Employee getEmployeeByAccount(String account) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		Employee emp = null;
		try {
			
			conn = ConnectionUtils.getConnection();
			
			String sql = "select e.employee_id, e.first_name, e.last_name,e.gender,e.date_of_birth, e.phone, "
					+ "e.address,e.deparment_name, e.remark "
					+ "from Employee e "
					+ "inner join Account a "
					+ "on e.employee_id = a.employee_id "
					+ "where a.account = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				emp = new Employee();
				emp.setEmployeeID(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setGender(rs.getInt(4));
				emp.setDob(LocalDate.parse(rs.getString(5)));
				emp.setPhone(rs.getString(6));
				emp.setAddress(rs.getString(7));
				emp.setDeptName(rs.getString(8));
				emp.setRemark(rs.getString(9));
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
	
	public Employee getEmployeeByID(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		Employee emp = null;
		try {
			
			conn = ConnectionUtils.getConnection();
			
			String sql =  "select * from Employee where employee_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				emp = new Employee();
				emp.setEmployeeID(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setGender(rs.getInt(4));
				emp.setDob(LocalDate.parse(rs.getString(5)));
				emp.setPhone(rs.getString(6));
				emp.setAddress(rs.getString(7));
				emp.setDeptName(rs.getString(8));
				emp.setRemark(rs.getString(9));
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

	public void insertEmp(Employee emp) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			
			conn = ConnectionUtils.getConnection();
			
			String sql = "	insert into Employee(first_name,last_name,gender,date_of_birth,phone,address"
					+ ",deparment_name,remark) values(?,?,?,?,?,?,?,?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getFirstName());
			pstmt.setString(2, emp.getLastName());
			pstmt.setInt(3, emp.getGender());
			pstmt.setString(4, emp.getDob().toString());
			pstmt.setString(5, emp.getPhone());
			pstmt.setString(6, emp.getAddress());
			pstmt.setString(7, emp.getDeptName());
			pstmt.setString(8, emp.getRemark());
			int checkInsert = pstmt.executeUpdate();
			
			if(checkInsert>0) {
				System.out.println("Insert Sucess!!!");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {

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

	}

	public void updateEmp(Employee emp) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			
			conn = ConnectionUtils.getConnection();
			
			String sql = "	update Employee set first_name = ? ,last_name = ? ,gender = ?,date_of_birth=?"
					+ ",phone = ?,address =? ,deparment_name =?,remark =? where employee_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getFirstName());
			pstmt.setString(2, emp.getLastName());
			pstmt.setInt(3, emp.getGender());
			pstmt.setString(4, emp.getDob().toString());
			pstmt.setString(5, emp.getPhone());
			pstmt.setString(6, emp.getAddress());
			pstmt.setString(7, emp.getDeptName());
			pstmt.setString(8, emp.getRemark());
			pstmt.setInt(9, emp.getEmployeeID());
			int checkInsert = pstmt.executeUpdate();
			
			if(checkInsert>0) {
				System.out.println("Update Sucess!!!");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {

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
	}
	
	public void deleteEmp(int id) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			
			conn = ConnectionUtils.getConnection();
			
			String sql = "delete employee where employee_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			int checkDelete = pstmt.executeUpdate();
			
			if(checkDelete>0) {
				System.out.println("Delete Sucess!!!");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {

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
	}
}
