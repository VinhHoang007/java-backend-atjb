package Model.DAO;

public class LoginDAO {

	public boolean checkUserInforDAO(String userName, String password) {
		// Connect DB .... Query...
		
		if("ronaldo".equals(userName) && "123".equals(password)){
			return true;
		}else{
			return false;
		}
	}

}
