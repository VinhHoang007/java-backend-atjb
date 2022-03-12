package demo.spring.mvc.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.spring.mvc.entities.UserEntity;

@Repository

public class UserRepository {
	@Autowired
	SessionFactory sf;

	public List<UserEntity> findAll(){
		Session session = sf.openSession();
		String strHql = "FROM Users";

		Query<UserEntity> hql= session.createQuery(strHql,UserEntity.class);
		
		List<UserEntity> result = hql.getResultList();
		
		return result;
	}
//	@Transactional
//	public List<UserDTO> FindAll() {
//		List<UserDTO> result = new ArrayList<UserDTO>();
//		Connection conn = null;
//		try {
//			conn = ConnectionUtils.getConnection();
//			String sql = "SELECT ID, Username, Password, Email From Users";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			ResultSet rs = pstmt.executeQuery();
//			UserDTO user;
//			while (rs.next()) {
//				user = new UserDTO();
//				user.setUserId(rs.getInt(1));
//				user.setUsername(rs.getString(2));
//				user.setPassword(rs.getString(3));
//				user.setEmail(rs.getString(4));	
//				result.add(user);
//				
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return result;
//	}
	@Transactional
	public UserEntity FindOne(int userID) {
		Connection conn = null;
		UserEntity user = null;
		try {
			conn = ConnectionUtils.getConnection();
			String sql = "SELECT ID, Username, Password, Email From Users where ID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,userID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserEntity();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));			
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}
	@Transactional
	public UserEntity FindOne(String username) {
		Connection conn = null;
		UserEntity user = null;
		try {
			conn = ConnectionUtils.getConnection();
			String sql = "SELECT ID, Username, Password, Email From Users where Username=?";
 			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserEntity();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));			
			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}
	@Transactional
	public boolean Add(String username, String password, String email) {
		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
			String sql = "insert into Users(username,password,email) values(?,?,?)";
 			PreparedStatement pstmt = conn.prepareStatement(sql);
 			pstmt.setString(1, username);
 			pstmt.setString(2, password);
 			pstmt.setString(3, email);
			int count = pstmt.executeUpdate();
			if(count>0) {
				System.out.println("Update Success!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn !=null) {
				try {
					conn.close();
				}catch (SQLException e) {
					
				}
			}
		}
		return true;
	}
	@Transactional
	public boolean Delete(int userId) {
		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
			String sql = "delete From Users where id=?";
 			PreparedStatement pstmt = conn.prepareStatement(sql);
 			pstmt.setInt(1, userId);
			int count = pstmt.executeUpdate();
			if(count>0) {
				System.out.println("Delete Success!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn !=null) {
				try {
					conn.close();
				}catch (SQLException e) {
					
				}
			}
		}
		return true;
	}
	
	@Transactional
	public boolean Update(int userId,String username, String password, String email) {
		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
			String sql = "update Users set username =?, password=?,email=? where id = ?";
 			PreparedStatement pstmt = conn.prepareStatement(sql);
 			pstmt.setString(1, username);
 			pstmt.setString(2, password);
 			pstmt.setString(3, email);
 			pstmt.setInt(4, userId);
			int count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn !=null) {
				try {
					conn.close();
				}catch (SQLException e) {
					
				}
			}
		}
		return true;
	}
	
}
