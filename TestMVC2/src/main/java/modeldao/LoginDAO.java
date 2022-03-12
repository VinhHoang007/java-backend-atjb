package modeldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.ConnectionUtils;

public class LoginDAO {


	public boolean checkUserInforDAO(String username, String password) {
		// Connect DB .... Query...
		if (checkAccount(username,password)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkAccount(String username,String password) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			
			conn = ConnectionUtils.getConnection();
			
			String sql = "select * from Account where account =? and password =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return true;
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
		return false;
	}


}
