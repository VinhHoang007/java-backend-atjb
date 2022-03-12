package demo.spring.mvc.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ConnectionUtils {
	 private static final String HOSTNAME = "localhost";
	    private static final String PORT = "1433";
	    private static final String DATABASE = "DemoSpringMVC";
	    private static final String URL = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";databaseName=" + DATABASE;
	    private static final String USER = "sa";
	    private static final String PW = "1234567890";
	 
	    public static Connection getConnection() {
	        try {
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            Connection conn = DriverManager.getConnection(URL, USER, PW);
	            return conn;
	        } catch (SQLException | ClassNotFoundException e) {
	            System.out.println("Database connection error !!!");
	            e.printStackTrace();
	        }
	        return null;
	    }
	    
	    
	 
	    public static void closeConnectionReSultPstmt(ResultSet rs, PreparedStatement pstmt) {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pstmt != null) {
	                pstmt.close();
	            }
	        } catch (SQLException e) {
	            System.out.println("Close Fail !!!");
	            e.printStackTrace();
	        }
	    }
	    public static void closeConnectionPstmt(PreparedStatement pstmt) {
	        try {
	            if (pstmt != null) {
	                pstmt.close();
	            }
	        } catch (SQLException e) {
	            System.out.println("Close Fail !!!");
	            e.printStackTrace();
	        }
	    }
	    

	    
	    public static void closeConnection(Connection conn) {
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            System.out.println("Close Fail !!!");
	            e.printStackTrace();
	        }
	    }

}
