package model.bo;

import modeldao.LoginDAO;

public class LoginBO {
	public boolean CheckLoginBO(String userName, String password) {
		if(userName == null || "".equals(userName) || password == null || "".equals(password)){
			return false;
		}else{
			LoginDAO loginDAO = new LoginDAO();
			if(loginDAO.checkUserInforDAO(userName, password)){
				return true;
			}else{
				return false;
			}
		}
	}
	
	
}
